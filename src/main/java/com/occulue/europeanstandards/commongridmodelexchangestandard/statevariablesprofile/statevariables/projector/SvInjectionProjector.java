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
 * Projector for SvInjection as outlined for the CQRS pattern. All event handling and query handling
 * related to SvInjection are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by SvInjectionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("svInjection")
@Component("svInjection-projector")
public class SvInjectionProjector extends SvInjectionEntityProjector {

  // core constructor
  public SvInjectionProjector(
      SvInjectionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSvInjectionEvent
   */
  @EventHandler(payloadType = CreateSvInjectionEvent.class)
  public void handle(CreateSvInjectionEvent event) {
    LOGGER.info("handling CreateSvInjectionEvent - " + event);
    SvInjection entity = new SvInjection();
    entity.setSvInjectionId(event.getSvInjectionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvInjection(entity);
  }

  /*
   * @param	event UpdateSvInjectionEvent
   */
  @EventHandler(payloadType = UpdateSvInjectionEvent.class)
  public void handle(UpdateSvInjectionEvent event) {
    LOGGER.info("handling UpdateSvInjectionEvent - " + event);

    SvInjection entity = new SvInjection();
    entity.setSvInjectionId(event.getSvInjectionId());
    entity.setPInjection(event.getPInjection());
    entity.setQInjection(event.getQInjection());
    entity.setSvInjection(event.getSvInjection());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvInjection(entity);
  }

  /*
   * @param	event DeleteSvInjectionEvent
   */
  @EventHandler(payloadType = DeleteSvInjectionEvent.class)
  public void handle(DeleteSvInjectionEvent event) {
    LOGGER.info("handling DeleteSvInjectionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SvInjection entity = delete(event.getSvInjectionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvInjection(entity);
  }

  /*
   * @param	event AssignPInjectionToSvInjectionEvent
   */
  @EventHandler(payloadType = AssignPInjectionToSvInjectionEvent.class)
  public void handle(AssignPInjectionToSvInjectionEvent event) {
    LOGGER.info("handling AssignPInjectionToSvInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvInjection entity = assignPInjection(event.getSvInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvInjection(entity);
  }

  /*
   * @param	event UnAssignPInjectionFromSvInjectionEvent
   */
  @EventHandler(payloadType = UnAssignPInjectionFromSvInjectionEvent.class)
  public void handle(UnAssignPInjectionFromSvInjectionEvent event) {
    LOGGER.info("handling UnAssignPInjectionFromSvInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvInjection entity = unAssignPInjection(event.getSvInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvInjection(entity);
  }

  /*
   * @param	event AssignQInjectionToSvInjectionEvent
   */
  @EventHandler(payloadType = AssignQInjectionToSvInjectionEvent.class)
  public void handle(AssignQInjectionToSvInjectionEvent event) {
    LOGGER.info("handling AssignQInjectionToSvInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvInjection entity = assignQInjection(event.getSvInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvInjection(entity);
  }

  /*
   * @param	event UnAssignQInjectionFromSvInjectionEvent
   */
  @EventHandler(payloadType = UnAssignQInjectionFromSvInjectionEvent.class)
  public void handle(UnAssignQInjectionFromSvInjectionEvent event) {
    LOGGER.info("handling UnAssignQInjectionFromSvInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvInjection entity = unAssignQInjection(event.getSvInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvInjection(entity);
  }

  /*
   * @param	event AssignSvInjectionToSvInjectionEvent
   */
  @EventHandler(payloadType = AssignSvInjectionToSvInjectionEvent.class)
  public void handle(AssignSvInjectionToSvInjectionEvent event) {
    LOGGER.info("handling AssignSvInjectionToSvInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvInjection entity = assignSvInjection(event.getSvInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvInjection(entity);
  }

  /*
   * @param	event UnAssignSvInjectionFromSvInjectionEvent
   */
  @EventHandler(payloadType = UnAssignSvInjectionFromSvInjectionEvent.class)
  public void handle(UnAssignSvInjectionFromSvInjectionEvent event) {
    LOGGER.info("handling UnAssignSvInjectionFromSvInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvInjection entity = unAssignSvInjection(event.getSvInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvInjection(entity);
  }

  /**
   * Method to retrieve the SvInjection via an SvInjectionPrimaryKey.
   *
   * @param id Long
   * @return SvInjection
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SvInjection handle(FindSvInjectionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSvInjectionId());
  }

  /**
   * Method to retrieve a collection of all SvInjections
   *
   * @param query FindAllSvInjectionQuery
   * @return List<SvInjection>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SvInjection> handle(FindAllSvInjectionQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSvInjection, but only if the id matches
   *
   * @param entity SvInjection
   */
  protected void emitFindSvInjection(SvInjection entity) {
    LOGGER.info("handling emitFindSvInjection");

    queryUpdateEmitter.emit(
        FindSvInjectionQuery.class,
        query -> query.getFilter().getSvInjectionId().equals(entity.getSvInjectionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSvInjection
   *
   * @param entity SvInjection
   */
  protected void emitFindAllSvInjection(SvInjection entity) {
    LOGGER.info("handling emitFindAllSvInjection");

    queryUpdateEmitter.emit(FindAllSvInjectionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(SvInjectionProjector.class.getName());
}
