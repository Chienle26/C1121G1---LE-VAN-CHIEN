import {DanhMuc} from './danhMuc';

export interface BatDongSan {
  id: number;
  danhMuc?: DanhMuc;
  vungMien?: string;
  banLa?: string;
  dangTin?: string;
  tinhTrang?: string;
  diaChi: string;
  dienTich: number;
  huong?: string;
  tuaDe: string;
  noiDung: string;
  gia: number;
  hinhAnh?: string;
}
