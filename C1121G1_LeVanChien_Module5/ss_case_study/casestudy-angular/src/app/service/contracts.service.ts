import {Injectable} from '@angular/core';
import {Contract} from '../model/contract';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContractsService {
  contractApi = 'http://localhost:3000/contract';

  constructor(private http: HttpClient) {
  }

  private contracts: Contract[] = [];

  getContracts(): Observable<Contract[]> {
    return this.http.get<Contract[]>(this.contractApi);
  }

  createContract(contract: Contract): Observable<any> {
    return this.http.post<any>(this.contractApi, contract);
  }
}
