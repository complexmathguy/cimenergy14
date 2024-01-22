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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SvVoltage as outlined for the CQRS pattern. All event handling and query handling
 * related to SvVoltage are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by SvVoltageAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("svVoltage")
@Component("svVoltage-projector")
public class SvVoltageProjector extends SvVoltageEntityProjector {

  // core constructor
  public SvVoltageProjector(SvVoltageRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSvVoltageEvent
   */
  @EventHandler(payloadType = CreateSvVoltageEvent.class)
  public void handle(CreateSvVoltageEvent event) {
    LOGGER.info("handling CreateSvVoltageEvent - " + event);
    SvVoltage entity = new SvVoltage();
    entity.setSvVoltageId(event.getSvVoltageId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvVoltage(entity);
  }

  /*
   * @param	event UpdateSvVoltageEvent
   */
  @EventHandler(payloadType = UpdateSvVoltageEvent.class)
  public void handle(UpdateSvVoltageEvent event) {
    LOGGER.info("handling UpdateSvVoltageEvent - " + event);

    SvVoltage entity = new SvVoltage();
    entity.setSvVoltageId(event.getSvVoltageId());
    entity.setAngle(event.getAngle());
    entity.setV(event.getV());
    entity.setSvVoltage(event.getSvVoltage());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvVoltage(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvVoltage(entity);
  }

  /*
   * @param	event DeleteSvVoltageEvent
   */
  @EventHandler(payloadType = DeleteSvVoltageEvent.class)
  public void handle(DeleteSvVoltageEvent event) {
    LOGGER.info("handling DeleteSvVoltageEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SvVoltage entity = delete(event.getSvVoltageId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvVoltage(entity);
  }

  /*
   * @param	event AssignAngleToSvVoltageEvent
   */
  @EventHandler(payloadType = AssignAngleToSvVoltageEvent.class)
  public void handle(AssignAngleToSvVoltageEvent event) {
    LOGGER.info("handling AssignAngleToSvVoltageEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvVoltage entity = assignAngle(event.getSvVoltageId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvVoltage(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvVoltage(entity);
  }

  /*
   * @param	event UnAssignAngleFromSvVoltageEvent
   */
  @EventHandler(payloadType = UnAssignAngleFromSvVoltageEvent.class)
  public void handle(UnAssignAngleFromSvVoltageEvent event) {
    LOGGER.info("handling UnAssignAngleFromSvVoltageEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvVoltage entity = unAssignAngle(event.getSvVoltageId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvVoltage(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvVoltage(entity);
  }

  /*
   * @param	event AssignVToSvVoltageEvent
   */
  @EventHandler(payloadType = AssignVToSvVoltageEvent.class)
  public void handle(AssignVToSvVoltageEvent event) {
    LOGGER.info("handling AssignVToSvVoltageEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvVoltage entity = assignV(event.getSvVoltageId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvVoltage(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvVoltage(entity);
  }

  /*
   * @param	event UnAssignVFromSvVoltageEvent
   */
  @EventHandler(payloadType = UnAssignVFromSvVoltageEvent.class)
  public void handle(UnAssignVFromSvVoltageEvent event) {
    LOGGER.info("handling UnAssignVFromSvVoltageEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvVoltage entity = unAssignV(event.getSvVoltageId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvVoltage(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvVoltage(entity);
  }

  /*
   * @param	event AssignSvVoltageToSvVoltageEvent
   */
  @EventHandler(payloadType = AssignSvVoltageToSvVoltageEvent.class)
  public void handle(AssignSvVoltageToSvVoltageEvent event) {
    LOGGER.info("handling AssignSvVoltageToSvVoltageEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvVoltage entity = assignSvVoltage(event.getSvVoltageId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvVoltage(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvVoltage(entity);
  }

  /*
   * @param	event UnAssignSvVoltageFromSvVoltageEvent
   */
  @EventHandler(payloadType = UnAssignSvVoltageFromSvVoltageEvent.class)
  public void handle(UnAssignSvVoltageFromSvVoltageEvent event) {
    LOGGER.info("handling UnAssignSvVoltageFromSvVoltageEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvVoltage entity = unAssignSvVoltage(event.getSvVoltageId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvVoltage(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvVoltage(entity);
  }

  /**
   * Method to retrieve the SvVoltage via an SvVoltagePrimaryKey.
   *
   * @param id Long
   * @return SvVoltage
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SvVoltage handle(FindSvVoltageQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSvVoltageId());
  }

  /**
   * Method to retrieve a collection of all SvVoltages
   *
   * @param query FindAllSvVoltageQuery
   * @return List<SvVoltage>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SvVoltage> handle(FindAllSvVoltageQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSvVoltage, but only if the id matches
   *
   * @param entity SvVoltage
   */
  protected void emitFindSvVoltage(SvVoltage entity) {
    LOGGER.info("handling emitFindSvVoltage");

    queryUpdateEmitter.emit(
        FindSvVoltageQuery.class,
        query -> query.getFilter().getSvVoltageId().equals(entity.getSvVoltageId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSvVoltage
   *
   * @param entity SvVoltage
   */
  protected void emitFindAllSvVoltage(SvVoltage entity) {
    LOGGER.info("handling emitFindAllSvVoltage");

    queryUpdateEmitter.emit(FindAllSvVoltageQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(SvVoltageProjector.class.getName());
}
