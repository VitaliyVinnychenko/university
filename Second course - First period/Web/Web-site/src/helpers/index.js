export function isOnline() {
    return !window.navigator.onLine;
}

export const USE_LOCAL_STORAGE = false;

export function getAllItems(name) {
    const items = window.localStorage.getItem(name);

    if (items === undefined) {
        return null;
    }

    return JSON.parse(items);
}

export function storageIsSupported() {

    if (window.localStorage === undefined) {
        alert('Storage API is not supported in your browser!');
        return false;
    }

    return true;
}

export function setZeroBefore(number) {
    if (number < 10) {
        return `0${ number }`;
    }

    return number;
}

export function checkStatus(response) {
    if (response.status >= 200 && response.status < 300) {
        return response.json();
    } else {
        let error = new Error(response.statusText);
        error.response = response;
        throw error;
    }
}
