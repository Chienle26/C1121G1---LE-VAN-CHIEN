import {Color} from './color';
import {Category} from './category';

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  quantity?: number;
  color?: Color;
  category?: Category;
  desc?: string;
}
