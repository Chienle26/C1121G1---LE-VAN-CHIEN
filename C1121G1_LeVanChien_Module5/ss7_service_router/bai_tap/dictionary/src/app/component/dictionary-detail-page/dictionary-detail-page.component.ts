import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DictionaryServiceService} from "../../service/dictionary-service.service";
import {IWord} from "../../model/i-word";

@Component({
  selector: 'app-dictionary-detail-page',
  templateUrl: './dictionary-detail-page.component.html',
  styleUrls: ['./dictionary-detail-page.component.css']
})
export class DictionaryDetailPageComponent implements OnInit {
  dictionary: IWord;
  id: number = 0;
  constructor(private activatedRoute: ActivatedRoute, private dictionaryService: DictionaryServiceService) {
    activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.id = parseInt(param.get('id'));
      if (this.id != null){
        this.dictionary = dictionaryService.findById(this.id);
      }
    });
  }

  ngOnInit(): void {
  }

}
