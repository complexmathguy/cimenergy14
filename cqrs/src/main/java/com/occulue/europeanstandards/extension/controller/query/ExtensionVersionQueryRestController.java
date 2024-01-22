/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.extension.controller.query;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller query CQRS processing for entity ExtensionVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExtensionVersion")
public class ExtensionVersionQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a ExtensionVersion using a UUID
   *
   * @param UUID extensionVersionId
   * @return ExtensionVersion
   */
  @GetMapping("/load")
  public ExtensionVersion load(@RequestParam(required = true) UUID extensionVersionId) {
    ExtensionVersion entity = null;

    try {
      entity =
          ExtensionVersionBusinessDelegate.getExtensionVersionInstance()
              .getExtensionVersion(new ExtensionVersionFetchOneSummary(extensionVersionId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load ExtensionVersion using Id " + extensionVersionId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all ExtensionVersion business objects
   *
   * @return Set<ExtensionVersion>
   */
  @GetMapping("/")
  public List<ExtensionVersion> loadAll() {
    List<ExtensionVersion> extensionVersionList = null;

    try {
      // load the ExtensionVersion
      extensionVersionList =
          ExtensionVersionBusinessDelegate.getExtensionVersionInstance().getAllExtensionVersion();

      if (extensionVersionList != null)
        LOGGER.log(Level.INFO, "successfully loaded all ExtensionVersions");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all ExtensionVersions ", exc);
      return null;
    }

    return extensionVersionList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExtensionVersion extensionVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExtensionVersionQueryRestController.class.getName());
}
