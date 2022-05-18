import {Injectable} from '@angular/core';
import {Facility} from '../model/facility';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FacilitiesService {
  facilityApi = 'http://localhost:3000/service';

  constructor(private http: HttpClient) {
  }

  getFacilities(): Observable<Facility[]> {
    return this.http.get<Facility[]>(this.facilityApi);
  }

  createFacility(facility: Facility): Observable<Facility> {
    return this.http.post<Facility>(this.facilityApi, facility);
  }

  findFacilityById(id: number): Observable<Facility> {
    return this.http.get<Facility>(this.facilityApi + '/' + id);
  }

  editFacility(facility: Facility, id: number): Observable<Facility> {
    return this.http.put<Facility>(this.facilityApi + '/' + id, facility);
  }

  deleteFacility(id: number): Observable<Facility> {
    return this.http.delete<Facility>(this.facilityApi + '/' + id);
  }
}
