const version = 1;
const cacheName = 'vaadin-cache-v' + version;
const staticAssets[
  './offline-page.html',
  './frontpage/images/icons/icon-512x512.png'
];

self.addEventListener('install', evt => {
  e.waitUntil(updateCache());
});


self.addEventListener('fetch', async evt => {
  const request = evt.request;

  if(acceptsHTML(request)){
      evt.respondWith(networkFirst(request));
  } else {
      if (request.cache === 'only-if-cached' && request.mode !== 'same-origin') {
        return;
      }
      evt.respondWith(cacheFirst(request));
  }
});

async function updateCache() {
  const cache = await caches.open(cacheName);
  cache.addAll(staticAssets);
}

function acceptsHTML(request) {
  return request.headers.get('Accept')
    .split(',')
    .some(type => type === 'text/html');
}

async function cacheFirst(request) {
  const cache = await caches.open(cacheName);
  const cached = await cache.match(request);

  return cached || fetch(request);
}

async function networkFirst(request) {
  try {
    return fetch(request);
  } catch {
    const cache = await caches.open(cacheName);
    return cache.match('./offline-page.html');
  }
}
