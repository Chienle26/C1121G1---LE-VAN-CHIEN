import {Customer} from './customer';
import {Facility} from './facility';

export interface Contract {
  contractId: number;
  contractStartDate: string;
  contractEndDate: string;
  contractDeposit: number;
  contractTotalMoney: number;
  employeeId: number;
  customer: Customer;
  services: Facility;
}
