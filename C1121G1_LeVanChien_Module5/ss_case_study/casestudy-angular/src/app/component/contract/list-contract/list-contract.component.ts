import {Component, OnInit} from '@angular/core';
import {Contract} from '../../../model/contract';
import {ContractsService} from '../../../service/contracts.service';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {
  title = 'List Contract';
  // @ts-ignore
  contracts = Array[Contract] = [];

  constructor(private contractsService: ContractsService) {
  }

  ngOnInit(): void {
    this.getAllContracts();
  }

  getAllContracts() {
    this.contractsService.getContracts().subscribe((contracts) => {
      this.contracts = contracts;
    }, error => {
      console.log(error);
    });
  }

}
