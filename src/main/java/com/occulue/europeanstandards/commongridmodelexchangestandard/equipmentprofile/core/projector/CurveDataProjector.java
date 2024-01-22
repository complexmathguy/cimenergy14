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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for CurveData as outlined for the CQRS pattern. All event handling and query handling
 * related to CurveData are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by CurveDataAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("curveData")
@Component("curveData-projector")
public class CurveDataProjector extends CurveDataEntityProjector {

  // core constructor
  public CurveDataProjector(CurveDataRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateCurveDataEvent
   */
  @EventHandler(payloadType = CreateCurveDataEvent.class)
  public void handle(CreateCurveDataEvent event) {
    LOGGER.info("handling CreateCurveDataEvent - " + event);
    CurveData entity = new CurveData();
    entity.setCurveDataId(event.getCurveDataId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event UpdateCurveDataEvent
   */
  @EventHandler(payloadType = UpdateCurveDataEvent.class)
  public void handle(UpdateCurveDataEvent event) {
    LOGGER.info("handling UpdateCurveDataEvent - " + event);

    CurveData entity = new CurveData();
    entity.setCurveDataId(event.getCurveDataId());
    entity.setXvalue(event.getXvalue());
    entity.setY1value(event.getY1value());
    entity.setY2value(event.getY2value());
    entity.setCurveDatas(event.getCurveDatas());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCurveData(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event DeleteCurveDataEvent
   */
  @EventHandler(payloadType = DeleteCurveDataEvent.class)
  public void handle(DeleteCurveDataEvent event) {
    LOGGER.info("handling DeleteCurveDataEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    CurveData entity = delete(event.getCurveDataId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event AssignXvalueToCurveDataEvent
   */
  @EventHandler(payloadType = AssignXvalueToCurveDataEvent.class)
  public void handle(AssignXvalueToCurveDataEvent event) {
    LOGGER.info("handling AssignXvalueToCurveDataEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CurveData entity = assignXvalue(event.getCurveDataId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCurveData(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event UnAssignXvalueFromCurveDataEvent
   */
  @EventHandler(payloadType = UnAssignXvalueFromCurveDataEvent.class)
  public void handle(UnAssignXvalueFromCurveDataEvent event) {
    LOGGER.info("handling UnAssignXvalueFromCurveDataEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CurveData entity = unAssignXvalue(event.getCurveDataId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCurveData(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event AssignY1valueToCurveDataEvent
   */
  @EventHandler(payloadType = AssignY1valueToCurveDataEvent.class)
  public void handle(AssignY1valueToCurveDataEvent event) {
    LOGGER.info("handling AssignY1valueToCurveDataEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CurveData entity = assignY1value(event.getCurveDataId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCurveData(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event UnAssignY1valueFromCurveDataEvent
   */
  @EventHandler(payloadType = UnAssignY1valueFromCurveDataEvent.class)
  public void handle(UnAssignY1valueFromCurveDataEvent event) {
    LOGGER.info("handling UnAssignY1valueFromCurveDataEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CurveData entity = unAssignY1value(event.getCurveDataId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCurveData(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event AssignY2valueToCurveDataEvent
   */
  @EventHandler(payloadType = AssignY2valueToCurveDataEvent.class)
  public void handle(AssignY2valueToCurveDataEvent event) {
    LOGGER.info("handling AssignY2valueToCurveDataEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CurveData entity = assignY2value(event.getCurveDataId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCurveData(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event UnAssignY2valueFromCurveDataEvent
   */
  @EventHandler(payloadType = UnAssignY2valueFromCurveDataEvent.class)
  public void handle(UnAssignY2valueFromCurveDataEvent event) {
    LOGGER.info("handling UnAssignY2valueFromCurveDataEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CurveData entity = unAssignY2value(event.getCurveDataId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCurveData(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event AssignCurveDatasToCurveDataEvent
   */
  @EventHandler(payloadType = AssignCurveDatasToCurveDataEvent.class)
  public void handle(AssignCurveDatasToCurveDataEvent event) {
    LOGGER.info("handling AssignCurveDatasToCurveDataEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    CurveData entity = addToCurveDatas(event.getCurveDataId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCurveData(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /*
   * @param	event RemoveCurveDatasFromCurveDataEvent
   */
  @EventHandler(payloadType = RemoveCurveDatasFromCurveDataEvent.class)
  public void handle(RemoveCurveDatasFromCurveDataEvent event) {
    LOGGER.info("handling RemoveCurveDatasFromCurveDataEvent - " + event);

    CurveData entity = removeFromCurveDatas(event.getCurveDataId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCurveData(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCurveData(entity);
  }

  /**
   * Method to retrieve the CurveData via an CurveDataPrimaryKey.
   *
   * @param id Long
   * @return CurveData
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public CurveData handle(FindCurveDataQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getCurveDataId());
  }

  /**
   * Method to retrieve a collection of all CurveDatas
   *
   * @param query FindAllCurveDataQuery
   * @return List<CurveData>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<CurveData> handle(FindAllCurveDataQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindCurveData, but only if the id matches
   *
   * @param entity CurveData
   */
  protected void emitFindCurveData(CurveData entity) {
    LOGGER.info("handling emitFindCurveData");

    queryUpdateEmitter.emit(
        FindCurveDataQuery.class,
        query -> query.getFilter().getCurveDataId().equals(entity.getCurveDataId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllCurveData
   *
   * @param entity CurveData
   */
  protected void emitFindAllCurveData(CurveData entity) {
    LOGGER.info("handling emitFindAllCurveData");

    queryUpdateEmitter.emit(FindAllCurveDataQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(CurveDataProjector.class.getName());
}
