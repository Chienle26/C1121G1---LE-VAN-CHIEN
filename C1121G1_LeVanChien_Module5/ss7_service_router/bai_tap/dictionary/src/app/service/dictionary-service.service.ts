import {Injectable} from '@angular/core';
import {IWord} from "../model/i-word";

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  dictionaries: Array<IWord> = [
    {id: 1, word: 'green', mean: 'xanh lá'},
    {id: 2, word: 'blue', mean: 'xanh biển'},
    {id: 3, word: 'orange', mean: 'cam'},
    {id: 4, word: 'red', mean: 'đỏ'},
    {id: 5, word: 'white', mean: 'trắng'}
  ];

  constructor() {
  }

  findById(id: number) {
    for (let dictionary of this.dictionaries) {
      if (dictionary.id === id) {
        return dictionary;
      }
    }
    return null;
  }
}
