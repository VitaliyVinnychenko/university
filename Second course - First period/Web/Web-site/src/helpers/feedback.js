import { storageIsSupported, getAllItems } from './index';


export function addFeedback(feedbackData) {
    if (!storageIsSupported()) {
        return null;
    }

    let feedbackList = getAllItems('feedback'),
        inputData = { ...feedbackData, date: new Date() };

    if (feedbackList === null) {
        window.localStorage.setItem('feedback', JSON.stringify({ items: [inputData] }));
    } else {
        feedbackList.items.push(inputData);
        window.localStorage.setItem('feedback', JSON.stringify(feedbackList));
    }
}
