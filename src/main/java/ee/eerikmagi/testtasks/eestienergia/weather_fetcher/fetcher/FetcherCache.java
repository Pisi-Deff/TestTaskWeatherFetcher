package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.fetcher;

import java.time.Duration;
import java.time.LocalDateTime;

public class FetcherCache<T, F extends IFetcher<T>> {
	private Duration cacheDuration;
	private IFetcher<T> fetcher;
	
	private T cachedObject;
	private LocalDateTime lastFetchTime;
	
	public FetcherCache(
		Duration cacheDuration,
		IFetcher<T> fetcher
	) {
		this.cacheDuration = cacheDuration;
		this.fetcher = fetcher;
	}
	
	public synchronized T getFresh() {
		this.cachedObject = this.fetcher.fetch();
		this.lastFetchTime = LocalDateTime.now();
		return this.cachedObject;
	}
	
	public T get() {
		if (isCacheTooOld()) {
			synchronized (this) {
				// recheck in case refresh happened in other thread
				if (isCacheTooOld()) {
					return this.getFresh();
				}
			}
		}
		
		return this.cachedObject;
	}
	
	private boolean isCacheTooOld() {
		if (this.cachedObject == null) {
			return true;
		}
		
		LocalDateTime cacheDeath = lastFetchTime.plus(this.cacheDuration);
		return cacheDeath.isBefore(LocalDateTime.now());
	}
}
