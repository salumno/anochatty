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
    AppRoutingModule
  ],
  providers: [UserService, PreferencesService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
