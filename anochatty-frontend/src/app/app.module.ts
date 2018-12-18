import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ChatNotificationComponent } from './chat-notification/chat-notification.component';
import { ChatComponent } from './chat/chat.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RegistrationComponent } from './registration/registration.component';
import { UserService } from './core/services/user.service';
import { PreferencesService } from './core/services/preferences.service';
import { AuthGuard } from './core/guard/auth.guard';
import { ButtonModule } from 'primeng/button';
import {
  DialogModule,
  DropdownModule,
  InputMaskModule,
  InputTextareaModule,
  InputTextModule,
  ListboxModule, ScrollPanelModule
} from 'primeng/primeng';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ChatNotificationComponent,
    ChatComponent,
    DashboardComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ButtonModule,
    DropdownModule,
    InputMaskModule,
    InputTextModule,
    InputTextareaModule,
    DialogModule,
    ListboxModule,
    FormsModule,
    ScrollPanelModule,
    HttpClientModule
  ],
  providers: [UserService, PreferencesService, AuthGuard, HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule {
}
