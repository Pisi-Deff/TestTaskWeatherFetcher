const WeatherFetcher = {};
WeatherFetcher.stations = null;

WeatherFetcher.$loading = document.getElementById('loading');
WeatherFetcher.$unexpectedError = document.getElementById('unexpectedError');

WeatherFetcher.$search = document.getElementById('search');
WeatherFetcher.$stationsList = document.getElementById('stations');
WeatherFetcher.$searchInput = WeatherFetcher.$search.querySelector('input[name=station]');
WeatherFetcher.$searchForm = document.getElementById('searchForm');
WeatherFetcher.$unknownStation = document.getElementById('unknownStation');
WeatherFetcher.$weatherReport = document.getElementById('weatherReport');

WeatherFetcher.$weatherReportTemplate = document.getElementById('template_weatherReport');
WeatherFetcher.weatherReportTemplate =
	Handlebars.compile(WeatherFetcher.$weatherReportTemplate.innerHTML);

WeatherFetcher.init = async function init() {
	try {
		const response = await request('api/stations', {
			method: 'GET'
		})
		
		WeatherFetcher.stations = response.stations;
		
		WeatherFetcher.stations.forEach(s => {
			const $option = document.createElement('option');
			$option.value = s.name;
			WeatherFetcher.$stationsList.append($option);
		});
	
		WeatherFetcher.$searchForm.addEventListener('submit', WeatherFetcher.search);
		WeatherFetcher.$loading.classList.add('hidden');
		WeatherFetcher.$search.classList.remove('hidden');
	} catch (e) {
		WeatherFetcher.$unexpectedError.classList.remove('hidden');
	}
	
};

WeatherFetcher.search = async function search(event) {
	event.preventDefault();

	WeatherFetcher.$unknownStation.classList.add('hidden');
	WeatherFetcher.$unexpectedError.classList.add('hidden');
	WeatherFetcher.$weatherReport.innerHTML = '';
	
	const value = WeatherFetcher.$searchInput.value;
	if (!value || !value.trim().length) {
		return;
	}
	
	const headers = new Headers();
	headers.append('Content-Type', 'application/json');
	
	try {
		const response = await request('api/stations', {
			method: 'POST',
			body: JSON.stringify({
				name: value.trim()
			}),
			headers: headers
		});
		
		WeatherFetcher.$weatherReport.innerHTML =
			WeatherFetcher.weatherReportTemplate(response.station);
	} catch (e) {
		if (e.response && e.response.status === 404) {
			WeatherFetcher.$unknownStation.querySelector('.stationName').innerText = value;
			WeatherFetcher.$unknownStation.classList.remove('hidden');
		} else {
			WeatherFetcher.$unexpectedError.classList.remove('hidden');
		}
	};
};

window.addEventListener("load", WeatherFetcher.init);

// wrap request to react to error
const request = async (...args) => {
	const response = await fetch(...args);
	const json = await response.json();
	const {success, ...data} = json;
	
	if (!success) {
		throw {
			response
		};
	}
	
	return data;
};
