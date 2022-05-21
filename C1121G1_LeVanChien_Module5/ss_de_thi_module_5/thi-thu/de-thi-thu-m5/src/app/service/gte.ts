import {AbstractControl} from '@angular/forms';

export function gte(control: AbstractControl) {
  const value = control.value;

  if (isNaN(value)) {
    return {gte: true, requireValue: 'Phải là số.'};
  }

  if (value < 0) {
    return {gte: true, requireValue: 'phải lớn hơn 0.'};
  }

  if (value <= 20) {
    return {gte: true, requireValue: 'Phải lớn hơn 20m2.'};
  }

  return null;
}
