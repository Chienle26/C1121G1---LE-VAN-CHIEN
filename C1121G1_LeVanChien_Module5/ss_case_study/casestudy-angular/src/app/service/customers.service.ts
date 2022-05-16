import {Injectable} from '@angular/core';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {
  customerApi = 'http://localhost:3000/customer';

  constructor(private http: HttpClient) {
  }

  private customers: Customer[] = [];

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customerApi);
  }

  createCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.customerApi, customer);
  }

  findCustomerById(id: number): Observable<Customer> {
    return this.http.get<Customer>(this.customerApi + '/' + id);
  }

  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(this.customerApi + '/' + id, customer);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.http.delete<Customer>(`${this.customerApi}/${id}`);
  }

}
