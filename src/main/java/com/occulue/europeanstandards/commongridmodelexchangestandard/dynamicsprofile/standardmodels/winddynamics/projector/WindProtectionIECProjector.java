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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for WindProtectionIEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindProtectionIEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindProtectionIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windProtectionIEC")
@Component("windProtectionIEC-projector")
public class WindProtectionIECProjector extends WindProtectionIECEntityProjector {

  // core constructor
  public WindProtectionIECProjector(
      WindProtectionIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindProtectionIECEvent
   */
  @EventHandler(payloadType = CreateWindProtectionIECEvent.class)
  public void handle(CreateWindProtectionIECEvent event) {
    LOGGER.info("handling CreateWindProtectionIECEvent - " + event);
    WindProtectionIEC entity = new WindProtectionIEC();
    entity.setWindProtectionIECId(event.getWindProtectionIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event UpdateWindProtectionIECEvent
   */
  @EventHandler(payloadType = UpdateWindProtectionIECEvent.class)
  public void handle(UpdateWindProtectionIECEvent event) {
    LOGGER.info("handling UpdateWindProtectionIECEvent - " + event);

    WindProtectionIEC entity = new WindProtectionIEC();
    entity.setWindProtectionIECId(event.getWindProtectionIECId());
    entity.setFover(event.getFover());
    entity.setFunder(event.getFunder());
    entity.setTfover(event.getTfover());
    entity.setTfunder(event.getTfunder());
    entity.setTuover(event.getTuover());
    entity.setTuunder(event.getTuunder());
    entity.setUover(event.getUover());
    entity.setUunder(event.getUunder());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event DeleteWindProtectionIECEvent
   */
  @EventHandler(payloadType = DeleteWindProtectionIECEvent.class)
  public void handle(DeleteWindProtectionIECEvent event) {
    LOGGER.info("handling DeleteWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindProtectionIEC entity = delete(event.getWindProtectionIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event AssignFoverToWindProtectionIECEvent
   */
  @EventHandler(payloadType = AssignFoverToWindProtectionIECEvent.class)
  public void handle(AssignFoverToWindProtectionIECEvent event) {
    LOGGER.info("handling AssignFoverToWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindProtectionIEC entity = assignFover(event.getWindProtectionIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event UnAssignFoverFromWindProtectionIECEvent
   */
  @EventHandler(payloadType = UnAssignFoverFromWindProtectionIECEvent.class)
  public void handle(UnAssignFoverFromWindProtectionIECEvent event) {
    LOGGER.info("handling UnAssignFoverFromWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindProtectionIEC entity = unAssignFover(event.getWindProtectionIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event AssignFunderToWindProtectionIECEvent
   */
  @EventHandler(payloadType = AssignFunderToWindProtectionIECEvent.class)
  public void handle(AssignFunderToWindProtectionIECEvent event) {
    LOGGER.info("handling AssignFunderToWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindProtectionIEC entity = assignFunder(event.getWindProtectionIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event UnAssignFunderFromWindProtectionIECEvent
   */
  @EventHandler(payloadType = UnAssignFunderFromWindProtectionIECEvent.class)
  public void handle(UnAssignFunderFromWindProtectionIECEvent event) {
    LOGGER.info("handling UnAssignFunderFromWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindProtectionIEC entity = unAssignFunder(event.getWindProtectionIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event AssignTfoverToWindProtectionIECEvent
   */
  @EventHandler(payloadType = AssignTfoverToWindProtectionIECEvent.class)
  public void handle(AssignTfoverToWindProtectionIECEvent event) {
    LOGGER.info("handling AssignTfoverToWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindProtectionIEC entity = assignTfover(event.getWindProtectionIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event UnAssignTfoverFromWindProtectionIECEvent
   */
  @EventHandler(payloadType = UnAssignTfoverFromWindProtectionIECEvent.class)
  public void handle(UnAssignTfoverFromWindProtectionIECEvent event) {
    LOGGER.info("handling UnAssignTfoverFromWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindProtectionIEC entity = unAssignTfover(event.getWindProtectionIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event AssignTfunderToWindProtectionIECEvent
   */
  @EventHandler(payloadType = AssignTfunderToWindProtectionIECEvent.class)
  public void handle(AssignTfunderToWindProtectionIECEvent event) {
    LOGGER.info("handling AssignTfunderToWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindProtectionIEC entity = assignTfunder(event.getWindProtectionIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event UnAssignTfunderFromWindProtectionIECEvent
   */
  @EventHandler(payloadType = UnAssignTfunderFromWindProtectionIECEvent.class)
  public void handle(UnAssignTfunderFromWindProtectionIECEvent event) {
    LOGGER.info("handling UnAssignTfunderFromWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindProtectionIEC entity = unAssignTfunder(event.getWindProtectionIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event AssignTuoverToWindProtectionIECEvent
   */
  @EventHandler(payloadType = AssignTuoverToWindProtectionIECEvent.class)
  public void handle(AssignTuoverToWindProtectionIECEvent event) {
    LOGGER.info("handling AssignTuoverToWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindProtectionIEC entity = assignTuover(event.getWindProtectionIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event UnAssignTuoverFromWindProtectionIECEvent
   */
  @EventHandler(payloadType = UnAssignTuoverFromWindProtectionIECEvent.class)
  public void handle(UnAssignTuoverFromWindProtectionIECEvent event) {
    LOGGER.info("handling UnAssignTuoverFromWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindProtectionIEC entity = unAssignTuover(event.getWindProtectionIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event AssignTuunderToWindProtectionIECEvent
   */
  @EventHandler(payloadType = AssignTuunderToWindProtectionIECEvent.class)
  public void handle(AssignTuunderToWindProtectionIECEvent event) {
    LOGGER.info("handling AssignTuunderToWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindProtectionIEC entity = assignTuunder(event.getWindProtectionIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event UnAssignTuunderFromWindProtectionIECEvent
   */
  @EventHandler(payloadType = UnAssignTuunderFromWindProtectionIECEvent.class)
  public void handle(UnAssignTuunderFromWindProtectionIECEvent event) {
    LOGGER.info("handling UnAssignTuunderFromWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindProtectionIEC entity = unAssignTuunder(event.getWindProtectionIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event AssignUoverToWindProtectionIECEvent
   */
  @EventHandler(payloadType = AssignUoverToWindProtectionIECEvent.class)
  public void handle(AssignUoverToWindProtectionIECEvent event) {
    LOGGER.info("handling AssignUoverToWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindProtectionIEC entity = assignUover(event.getWindProtectionIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event UnAssignUoverFromWindProtectionIECEvent
   */
  @EventHandler(payloadType = UnAssignUoverFromWindProtectionIECEvent.class)
  public void handle(UnAssignUoverFromWindProtectionIECEvent event) {
    LOGGER.info("handling UnAssignUoverFromWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindProtectionIEC entity = unAssignUover(event.getWindProtectionIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event AssignUunderToWindProtectionIECEvent
   */
  @EventHandler(payloadType = AssignUunderToWindProtectionIECEvent.class)
  public void handle(AssignUunderToWindProtectionIECEvent event) {
    LOGGER.info("handling AssignUunderToWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindProtectionIEC entity = assignUunder(event.getWindProtectionIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /*
   * @param	event UnAssignUunderFromWindProtectionIECEvent
   */
  @EventHandler(payloadType = UnAssignUunderFromWindProtectionIECEvent.class)
  public void handle(UnAssignUunderFromWindProtectionIECEvent event) {
    LOGGER.info("handling UnAssignUunderFromWindProtectionIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindProtectionIEC entity = unAssignUunder(event.getWindProtectionIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindProtectionIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindProtectionIEC(entity);
  }

  /**
   * Method to retrieve the WindProtectionIEC via an WindProtectionIECPrimaryKey.
   *
   * @param id Long
   * @return WindProtectionIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindProtectionIEC handle(FindWindProtectionIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindProtectionIECId());
  }

  /**
   * Method to retrieve a collection of all WindProtectionIECs
   *
   * @param query FindAllWindProtectionIECQuery
   * @return List<WindProtectionIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindProtectionIEC> handle(FindAllWindProtectionIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindProtectionIEC, but only if the id matches
   *
   * @param entity WindProtectionIEC
   */
  protected void emitFindWindProtectionIEC(WindProtectionIEC entity) {
    LOGGER.info("handling emitFindWindProtectionIEC");

    queryUpdateEmitter.emit(
        FindWindProtectionIECQuery.class,
        query -> query.getFilter().getWindProtectionIECId().equals(entity.getWindProtectionIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindProtectionIEC
   *
   * @param entity WindProtectionIEC
   */
  protected void emitFindAllWindProtectionIEC(WindProtectionIEC entity) {
    LOGGER.info("handling emitFindAllWindProtectionIEC");

    queryUpdateEmitter.emit(FindAllWindProtectionIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(WindProtectionIECProjector.class.getName());
}
