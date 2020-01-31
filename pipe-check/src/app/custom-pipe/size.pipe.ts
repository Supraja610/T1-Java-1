import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'size'
})
export class SizePipe implements PipeTransform {

  // originalValue : originalValue to transform
  // type : option
  transform(originalValue: number, type : string = "MB"): string {
    let response = "";
      switch(type){
        case "MB" : response = (originalValue / (1024 * 1024)).toFixed(2) + " MB"; break;
        case "KB" : response = (originalValue / (1024)).toFixed(2) + " KB"; break;
        default : response = originalValue + " bytes";
      }
      return response;
  }

}
