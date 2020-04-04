import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app.routing.module";
import {AppLayoutComponent, FooterComponent, HeaderComponent, SidebarComponent} from "./_layout";
import {BsDatepickerModule} from "ngx-bootstrap/datepicker";
import {BsDropdownModule} from "ngx-bootstrap";
import {CollapseModule} from "ngx-bootstrap";
import {ModalModule} from "ngx-bootstrap";
import {PaginationModule} from "ngx-bootstrap";
import {ToastNoAnimation} from "ngx-toastr";
import {ToastNoAnimationModule} from "ngx-toastr";
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClient} from "@angular/common/http"
import {HttpClientModule} from "@angular/common/http";
import {TranslateLoader} from "@ngx-translate/core";
import {TranslateModule} from "@ngx-translate/core";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {DashboardModule} from "./pages/dashboard/dashboard.module";
import {ProjectModule} from "./pages/project/project.module";
import {IssueModule} from "./pages/issue/issue.module";
import {ApiService} from "./services/api.service";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";

export const createTranslateLoader = (http: HttpClient) => {
  return new TranslateHttpLoader(http, './assets/i18n)', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    AppLayoutComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DashboardModule,
    ProjectModule,
    IssueModule,
    NgxDatatableModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CollapseModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    PaginationModule.forRoot(),
    BsDatepickerModule.forRoot(),
    ToastNoAnimationModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: createTranslateLoader,
        deps: [HttpClient]
      }

    }),
    ToastrModule.forRoot({
      toastComponent: ToastNoAnimation,
      maxOpened: 1,
      autoDismiss: true
    }),
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
