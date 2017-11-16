const WeatherFetcher = {};
WeatherFetcher.stations = null;

WeatherFetcher.$loading = document.getElementById('loading');

WeatherFetcher.$search = document.getElementById('search');
WeatherFetcher.$stationsList = document.getElementById('stations');
WeatherFetcher.$searchInput = WeatherFetcher.$search.querySelector('input[name=station]');
WeatherFetcher.$searchForm = document.getElementById('searchForm');
WeatherFetcher.$weatherReport = document.getElementById('weatherReport');

WeatherFetcher.$weatherReportTemplate = document.getElementById('template_weatherReport');
WeatherFetcher.weatherReportTemplate =
	Handlebars.compile(WeatherFetcher.$weatherReportTemplate.innerHTML);

WeatherFetcher.init = function init() {
	request('api/stations', {
		method: 'GET'
	}).then((data) => {
		WeatherFetcher.stations = data.stations;
		
		WeatherFetcher.stations.forEach(s => {
			const $option = document.createElement('option');
			$option.value = s.name;
			WeatherFetcher.$stationsList.append($option);
		});
		
		WeatherFetcher.$loading.classList.add('hidden');
		WeatherFetcher.$search.classList.remove('hidden');
	});
	
	WeatherFetcher.$searchForm.addEventListener('submit', WeatherFetcher.search);
};

WeatherFetcher.search = function search(event) {
	event.preventDefault();
	
	WeatherFetcher.$weatherReport.innerHTML = '';
	
	const value = WeatherFetcher.$searchInput.value;
	if (!value || !value.length) {
		return;
	}
	
	const headers = new Headers();
	headers.append('Content-Type', 'application/json');
	
	request('api/stations', {
		method: 'POST',
		body: JSON.stringify({
			name: value
		}),
		headers: headers
	}).then((data) => {
		WeatherFetcher.$weatherReport.innerHTML =
			WeatherFetcher.weatherReportTemplate(data.station);
	}).catch(() => {
		console.error('Hello!!!');
	});
};

window.addEventListener("load", WeatherFetcher.init);

// wrap request to react to error
const request = (...args) => {
	const promise = fetch(...args)
		.then((response) => response.json())
		.then(({success, ...rest}) => {
			if (!success) {
				console.error('fail!');
				throw new Error();
			}
			
			return rest;
		});
	
	promise.catch(() => {
		throw new Error();
	});
	
	return promise;
};
