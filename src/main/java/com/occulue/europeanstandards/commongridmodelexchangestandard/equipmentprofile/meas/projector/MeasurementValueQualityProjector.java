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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for MeasurementValueQuality as outlined for the CQRS pattern. All event handling and
 * query handling related to MeasurementValueQuality are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by MeasurementValueQualityAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("measurementValueQuality")
@Component("measurementValueQuality-projector")
public class MeasurementValueQualityProjector extends MeasurementValueQualityEntityProjector {

  // core constructor
  public MeasurementValueQualityProjector(
      MeasurementValueQualityRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateMeasurementValueQualityEvent
   */
  @EventHandler(payloadType = CreateMeasurementValueQualityEvent.class)
  public void handle(CreateMeasurementValueQualityEvent event) {
    LOGGER.info("handling CreateMeasurementValueQualityEvent - " + event);
    MeasurementValueQuality entity = new MeasurementValueQuality();
    entity.setMeasurementValueQualityId(event.getMeasurementValueQualityId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMeasurementValueQuality(entity);
  }

  /*
   * @param	event UpdateMeasurementValueQualityEvent
   */
  @EventHandler(payloadType = UpdateMeasurementValueQualityEvent.class)
  public void handle(UpdateMeasurementValueQualityEvent event) {
    LOGGER.info("handling UpdateMeasurementValueQualityEvent - " + event);

    MeasurementValueQuality entity = new MeasurementValueQuality();
    entity.setMeasurementValueQualityId(event.getMeasurementValueQualityId());
    entity.setMeasurementValueQuality(event.getMeasurementValueQuality());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMeasurementValueQuality(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMeasurementValueQuality(entity);
  }

  /*
   * @param	event DeleteMeasurementValueQualityEvent
   */
  @EventHandler(payloadType = DeleteMeasurementValueQualityEvent.class)
  public void handle(DeleteMeasurementValueQualityEvent event) {
    LOGGER.info("handling DeleteMeasurementValueQualityEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    MeasurementValueQuality entity = delete(event.getMeasurementValueQualityId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMeasurementValueQuality(entity);
  }

  /*
   * @param	event AssignMeasurementValueQualityToMeasurementValueQualityEvent
   */
  @EventHandler(payloadType = AssignMeasurementValueQualityToMeasurementValueQualityEvent.class)
  public void handle(AssignMeasurementValueQualityToMeasurementValueQualityEvent event) {
    LOGGER.info("handling AssignMeasurementValueQualityToMeasurementValueQualityEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    MeasurementValueQuality entity =
        assignMeasurementValueQuality(event.getMeasurementValueQualityId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMeasurementValueQuality(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMeasurementValueQuality(entity);
  }

  /*
   * @param	event UnAssignMeasurementValueQualityFromMeasurementValueQualityEvent
   */
  @EventHandler(payloadType = UnAssignMeasurementValueQualityFromMeasurementValueQualityEvent.class)
  public void handle(UnAssignMeasurementValueQualityFromMeasurementValueQualityEvent event) {
    LOGGER.info(
        "handling UnAssignMeasurementValueQualityFromMeasurementValueQualityEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    MeasurementValueQuality entity =
        unAssignMeasurementValueQuality(event.getMeasurementValueQualityId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMeasurementValueQuality(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMeasurementValueQuality(entity);
  }

  /**
   * Method to retrieve the MeasurementValueQuality via an MeasurementValueQualityPrimaryKey.
   *
   * @param id Long
   * @return MeasurementValueQuality
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public MeasurementValueQuality handle(FindMeasurementValueQualityQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getMeasurementValueQualityId());
  }

  /**
   * Method to retrieve a collection of all MeasurementValueQualitys
   *
   * @param query FindAllMeasurementValueQualityQuery
   * @return List<MeasurementValueQuality>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<MeasurementValueQuality> handle(FindAllMeasurementValueQualityQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindMeasurementValueQuality, but only if the id matches
   *
   * @param entity MeasurementValueQuality
   */
  protected void emitFindMeasurementValueQuality(MeasurementValueQuality entity) {
    LOGGER.info("handling emitFindMeasurementValueQuality");

    queryUpdateEmitter.emit(
        FindMeasurementValueQualityQuery.class,
        query ->
            query
                .getFilter()
                .getMeasurementValueQualityId()
                .equals(entity.getMeasurementValueQualityId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllMeasurementValueQuality
   *
   * @param entity MeasurementValueQuality
   */
  protected void emitFindAllMeasurementValueQuality(MeasurementValueQuality entity) {
    LOGGER.info("handling emitFindAllMeasurementValueQuality");

    queryUpdateEmitter.emit(FindAllMeasurementValueQualityQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(MeasurementValueQualityProjector.class.getName());
}
