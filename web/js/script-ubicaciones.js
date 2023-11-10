// abicamos los datos en los input de la modal
            $(document).ready(function () {
                $('.edit-btn').click(function () {
                    var ubi_codigo = $(this).data('ubi_codigo');
                    var ubi_descrip = $(this).data('ubi_descrip');
                    var ubi_centrocosto = $(this).data('ubi_centrocosto');
                    var ubi_id = $(this).data('ubi_id');

                    $('#ubi_codigo').val(ubi_codigo);
                    $('#ubi_descrip').val(ubi_descrip);
                    $('#ubi_centrocosto').val(ubi_centrocosto);
                    $('#ubi_id').val(ubi_id);

                });              
            });


