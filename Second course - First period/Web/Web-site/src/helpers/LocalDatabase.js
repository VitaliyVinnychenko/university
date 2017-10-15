export default class LocalDatabase {

    constructor(databaseName) {
        this.databaseName = databaseName;

        this.indexedDB = window.indexedDB || window.mozIndexedDB || window.webkitIndexedDB || window.msIndexedDB;
        this.IDBTransaction = window.IDBTransaction || window.webkitIDBTransaction || window.msIDBTransaction;

        this.setup();
    }

    async setup() {
        if (!this.isSupported) {
            alert('IndexedDB is not supported in your browser');
            return null;
        }

        const connection = this.connectToDatabase();

        connection.onerror = err => console.error(err);

        connection.onupgradeneeded = await function(event) {
            const db = event.target.result;

            if (!db.objectStoreNames.contains('feedback')) {
                const objectStore = db.createObjectStore('feedback', { autoIncrement: true });

                objectStore.createIndex('name', 'name', { unique: false });
                objectStore.createIndex('text', 'text', { unique: false });
                objectStore.createIndex('created_at', 'created_at', { unique: false });
            }

            if (!db.objectStoreNames.contains('articles')) {
                const objectStore = db.createObjectStore('articles', { autoIncrement: true });

                objectStore.createIndex('title', 'title', { unique: false });
                objectStore.createIndex('image', 'image', { unique: false });
                objectStore.createIndex('short_text', 'short_text', { unique: false });
                objectStore.createIndex('full_text', 'full_text', { unique: false });
                objectStore.createIndex('created_at', 'created_at', { unique: false });
            }
        };
    }

    isSupported() {
        return this.indexedDB in "window";
    }

    connectToDatabase() {
        return this.indexedDB.open(this.databaseName, 1);
    }

    insert(storeName, data) {
        const db = this.connectToDatabase();

        db.onerror = err => console.log(err);

        db.onsuccess = e => {
            const transaction = e.target.result.transaction([storeName], 'readwrite');
            const objectStore = transaction.objectStore(storeName);

            transaction.onerror = error => console.error(error);

            const request = objectStore.add({ ...data, created_at: new Date() });

            request.onsuccess = event => console.log(event.target.result);
        };
    }
}
