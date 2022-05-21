import {AbstractControl} from '@angular/forms';

export function gte2(control: AbstractControl) {
  const value = control.value;

  if (value <= 100000000) {
    return {gte2: true, requireValue: 'Phải lớn hơn 100.000.000.'};
  }

  return null;
}
