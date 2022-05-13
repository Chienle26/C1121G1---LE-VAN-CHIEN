import { Component, OnInit } from '@angular/core';
import {IWord} from "../../model/i-word";
import {DictionaryServiceService} from "../../service/dictionary-service.service";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  dictionaries: Array<IWord> = [];

  constructor(private dictionaryService: DictionaryServiceService) {
    this.dictionaries = this.dictionaryService.dictionaries;
  }

  ngOnInit(): void {
  }

}
