import {Customer} from './customer';
import {Facility} from './facility';
import {Employee} from './employee';

export interface Contract {
  id: number;
  contractStartDate: string;
  contractEndDate: string;
  contractDeposit: number;
  contractTotalMoney: number;
  employee: Employee;
  customer: Customer;
  services: Facility;
}
