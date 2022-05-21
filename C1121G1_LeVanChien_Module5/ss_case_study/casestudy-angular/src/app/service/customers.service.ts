import {Injectable} from '@angular/core';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {
  // customerApi = 'http://localhost:3000/customer';
  customerApi = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  private customers: Customer[] = [];

  getCustomersPage(page: number): Observable<any> {
    return this.http.get<any>(this.customerApi + '/customer?page=' + page);
  }

  getCustomers(): Observable<any> {
    return this.http.get<any>(this.customerApi + '/customer/list');
  }

  deleteById(idDelete: number): Observable<Customer> {
    return this.http.delete<Customer>(`${this.customerApi}/customer/delete/${idDelete}`);
  }

  save(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${this.customerApi}/customer/create`, customer);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.customerApi}/customer/${id}`);
  }

  editCustomer(customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.customerApi}/customer/edit/${customer.id}`, customer);
  }


  // createCustomer(customer: Customer): Observable<Customer> {
  //   return this.http.post<Customer>(this.customerApi, customer);
  // }
  //
  // findCustomerById(id: number): Observable<Customer> {
  //   return this.http.get<Customer>(this.customerApi + '/' + id);
  // }
  //
  // updateCustomer(id: number, customer: Customer): Observable<Customer> {
  //   return this.http.put<Customer>(this.customerApi + '/' + id, customer);
  // }
  //
  // deleteCustomer(id: number): Observable<Customer> {
  //   return this.http.delete<Customer>(`${this.customerApi}/${id}`);
  // }

}
