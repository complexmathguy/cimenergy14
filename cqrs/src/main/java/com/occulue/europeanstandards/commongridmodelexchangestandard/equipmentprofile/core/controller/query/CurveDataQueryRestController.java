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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity CurveData.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CurveData")
public class CurveDataQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a CurveData using a UUID
   *
   * @param UUID curveDataId
   * @return CurveData
   */
  @GetMapping("/load")
  public CurveData load(@RequestParam(required = true) UUID curveDataId) {
    CurveData entity = null;

    try {
      entity =
          CurveDataBusinessDelegate.getCurveDataInstance()
              .getCurveData(new CurveDataFetchOneSummary(curveDataId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load CurveData using Id " + curveDataId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all CurveData business objects
   *
   * @return Set<CurveData>
   */
  @GetMapping("/")
  public List<CurveData> loadAll() {
    List<CurveData> curveDataList = null;

    try {
      // load the CurveData
      curveDataList = CurveDataBusinessDelegate.getCurveDataInstance().getAllCurveData();

      if (curveDataList != null) LOGGER.log(Level.INFO, "successfully loaded all CurveDatas");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all CurveDatas ", exc);
      return null;
    }

    return curveDataList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected CurveData curveData = null;
  private static final Logger LOGGER =
      Logger.getLogger(CurveDataQueryRestController.class.getName());
}
