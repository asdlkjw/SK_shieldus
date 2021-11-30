package com.example.android.camera2basic

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment

/**
 * Shows OK/Cancel confirmation dialog about camera permission.
 */
class ConfirmationDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
            AlertDialog.Builder(activity)
                    .setMessage(R.string.request_permission)
                    .setPositiveButton(android.R.string.ok) { _, _ ->
                        parentFragment.requestPermissions(arrayOf(
                                Manifest.permission.CAMERA
                                , Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.READ_EXTERNAL_STORAGE)
                            , REQUEST_CAMERA_PERMISSION)
                    }
                    .setNegativeButton(android.R.string.cancel) { _, _ ->
                        parentFragment.activity?.finish()
                    }
                    .create()
}
