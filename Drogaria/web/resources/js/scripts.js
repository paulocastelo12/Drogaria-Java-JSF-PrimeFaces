/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 function verificar(xhr, status, args, dlg, tbl) {
        if(args.validationFailed) {
            PF(dlg).jq.effect("shake", {times:5}, 100);
        }
        else {
            PF(dlg).hide();
            PF(tbl).clearFilters();
        }
    }


