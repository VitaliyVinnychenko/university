import { storageIsSupported, getAllItems } from './index';


export function addArticle(articleData) {
    if (!storageIsSupported()) {
        return null;
    }

    let articles = getAllItems('articles'),
        inputData = { ...articleData, created_at: new Date() };

    if (articles === null) {
        window.localStorage.setItem('articles', JSON.stringify({ items: [inputData] }));
    } else {
        articles.items.push(inputData);
        window.localStorage.setItem('articles', JSON.stringify(articles));
    }
}
