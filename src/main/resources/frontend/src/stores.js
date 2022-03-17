import { writable, readable } from 'svelte/store';
import { browser } from '$app/env';

export const API_URL = readable('http://localhost:8080/api');

export const currentCustomer = writable(
  browser && (JSON.parse(sessionStorage.getItem('currentCustomer')) || '')
);
currentCustomer.subscribe(
  (val) => browser && sessionStorage.setItem('currentCustomer', JSON.stringify(val))
);

export const currentUser = writable(
  browser && (JSON.parse(sessionStorage.getItem('currentUser')) || '')
);
currentUser.subscribe(
  (val) => browser && sessionStorage.setItem('currentUser', JSON.stringify(val))
);
