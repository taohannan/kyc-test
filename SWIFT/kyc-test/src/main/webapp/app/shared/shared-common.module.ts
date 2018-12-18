import { NgModule } from '@angular/core';

import { KycTestSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [KycTestSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [KycTestSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class KycTestSharedCommonModule {}
