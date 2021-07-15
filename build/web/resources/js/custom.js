jQuery.fn.extend({
    overlay: function (val) {
        this.each(function () {
            let id = $(this).attr('id');
            $(this).find(`#${id}_generated_overlay`).remove();
            if (val) {
                if ($(this).hasClass('modal')) {
                    var ov = `<div id="${id}_generated_overlay" class="overlay justify-content-center align-items-center d-flex">
                        <i class="fas fa-2x fa-sync-alt fa-spin"></i>
                      </div>`;
                    $(this).find('.modal-content').prepend(ov);
                } else if ($(this).hasClass('card')) {
                    var ov = `<div id="${id}_generated_overlay" class="overlay dark">
                        <i class="fas fa-2x fa-sync-alt fa-spin"></i>
                      </div>`;
                    $(this).prepend(ov);
                }
            }
        });
    }
});
function showDeleteModal(show) {
    let action = show ? 'show' : 'hide';
    $('#deleteItem').modal(action);
}
function showManageModal(show) {
    let action = show ? 'show' : 'hide';
    $('#manageItem').modal(action);
}