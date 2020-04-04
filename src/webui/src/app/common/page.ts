export class Page {

  constructor() {
    this.size=10;
    this.page=0;
  }

  //The number of elements in page
  size: number = 0;
  //the total number of elements
  totalElements: number = 0;
  //The total number of pages
  totalPages: number = 0;
  //the current page number
  page: number = 0;
}
