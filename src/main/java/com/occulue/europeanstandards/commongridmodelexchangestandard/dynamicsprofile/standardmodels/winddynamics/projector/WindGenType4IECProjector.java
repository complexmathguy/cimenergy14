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
 * Projector for WindGenType4IEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindGenType4IEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindGenType4IECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windGenType4IEC")
@Component("windGenType4IEC-projector")
public class WindGenType4IECProjector extends WindGenType4IECEntityProjector {

  // core constructor
  public WindGenType4IECProjector(
      WindGenType4IECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindGenType4IECEvent
   */
  @EventHandler(payloadType = CreateWindGenType4IECEvent.class)
  public void handle(CreateWindGenType4IECEvent event) {
    LOGGER.info("handling CreateWindGenType4IECEvent - " + event);
    WindGenType4IEC entity = new WindGenType4IEC();
    entity.setWindGenType4IECId(event.getWindGenType4IECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event UpdateWindGenType4IECEvent
   */
  @EventHandler(payloadType = UpdateWindGenType4IECEvent.class)
  public void handle(UpdateWindGenType4IECEvent event) {
    LOGGER.info("handling UpdateWindGenType4IECEvent - " + event);

    WindGenType4IEC entity = new WindGenType4IEC();
    entity.setWindGenType4IECId(event.getWindGenType4IECId());
    entity.setDipmax(event.getDipmax());
    entity.setDiqmax(event.getDiqmax());
    entity.setDiqmin(event.getDiqmin());
    entity.setTg(event.getTg());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenType4IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event DeleteWindGenType4IECEvent
   */
  @EventHandler(payloadType = DeleteWindGenType4IECEvent.class)
  public void handle(DeleteWindGenType4IECEvent event) {
    LOGGER.info("handling DeleteWindGenType4IECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindGenType4IEC entity = delete(event.getWindGenType4IECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event AssignDipmaxToWindGenType4IECEvent
   */
  @EventHandler(payloadType = AssignDipmaxToWindGenType4IECEvent.class)
  public void handle(AssignDipmaxToWindGenType4IECEvent event) {
    LOGGER.info("handling AssignDipmaxToWindGenType4IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindGenType4IEC entity = assignDipmax(event.getWindGenType4IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenType4IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event UnAssignDipmaxFromWindGenType4IECEvent
   */
  @EventHandler(payloadType = UnAssignDipmaxFromWindGenType4IECEvent.class)
  public void handle(UnAssignDipmaxFromWindGenType4IECEvent event) {
    LOGGER.info("handling UnAssignDipmaxFromWindGenType4IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindGenType4IEC entity = unAssignDipmax(event.getWindGenType4IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenType4IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event AssignDiqmaxToWindGenType4IECEvent
   */
  @EventHandler(payloadType = AssignDiqmaxToWindGenType4IECEvent.class)
  public void handle(AssignDiqmaxToWindGenType4IECEvent event) {
    LOGGER.info("handling AssignDiqmaxToWindGenType4IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindGenType4IEC entity = assignDiqmax(event.getWindGenType4IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenType4IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event UnAssignDiqmaxFromWindGenType4IECEvent
   */
  @EventHandler(payloadType = UnAssignDiqmaxFromWindGenType4IECEvent.class)
  public void handle(UnAssignDiqmaxFromWindGenType4IECEvent event) {
    LOGGER.info("handling UnAssignDiqmaxFromWindGenType4IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindGenType4IEC entity = unAssignDiqmax(event.getWindGenType4IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenType4IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event AssignDiqminToWindGenType4IECEvent
   */
  @EventHandler(payloadType = AssignDiqminToWindGenType4IECEvent.class)
  public void handle(AssignDiqminToWindGenType4IECEvent event) {
    LOGGER.info("handling AssignDiqminToWindGenType4IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindGenType4IEC entity = assignDiqmin(event.getWindGenType4IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenType4IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event UnAssignDiqminFromWindGenType4IECEvent
   */
  @EventHandler(payloadType = UnAssignDiqminFromWindGenType4IECEvent.class)
  public void handle(UnAssignDiqminFromWindGenType4IECEvent event) {
    LOGGER.info("handling UnAssignDiqminFromWindGenType4IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindGenType4IEC entity = unAssignDiqmin(event.getWindGenType4IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenType4IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event AssignTgToWindGenType4IECEvent
   */
  @EventHandler(payloadType = AssignTgToWindGenType4IECEvent.class)
  public void handle(AssignTgToWindGenType4IECEvent event) {
    LOGGER.info("handling AssignTgToWindGenType4IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindGenType4IEC entity = assignTg(event.getWindGenType4IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenType4IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /*
   * @param	event UnAssignTgFromWindGenType4IECEvent
   */
  @EventHandler(payloadType = UnAssignTgFromWindGenType4IECEvent.class)
  public void handle(UnAssignTgFromWindGenType4IECEvent event) {
    LOGGER.info("handling UnAssignTgFromWindGenType4IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindGenType4IEC entity = unAssignTg(event.getWindGenType4IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindGenType4IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindGenType4IEC(entity);
  }

  /**
   * Method to retrieve the WindGenType4IEC via an WindGenType4IECPrimaryKey.
   *
   * @param id Long
   * @return WindGenType4IEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindGenType4IEC handle(FindWindGenType4IECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindGenType4IECId());
  }

  /**
   * Method to retrieve a collection of all WindGenType4IECs
   *
   * @param query FindAllWindGenType4IECQuery
   * @return List<WindGenType4IEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindGenType4IEC> handle(FindAllWindGenType4IECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindGenType4IEC, but only if the id matches
   *
   * @param entity WindGenType4IEC
   */
  protected void emitFindWindGenType4IEC(WindGenType4IEC entity) {
    LOGGER.info("handling emitFindWindGenType4IEC");

    queryUpdateEmitter.emit(
        FindWindGenType4IECQuery.class,
        query -> query.getFilter().getWindGenType4IECId().equals(entity.getWindGenType4IECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindGenType4IEC
   *
   * @param entity WindGenType4IEC
   */
  protected void emitFindAllWindGenType4IEC(WindGenType4IEC entity) {
    LOGGER.info("handling emitFindAllWindGenType4IEC");

    queryUpdateEmitter.emit(FindAllWindGenType4IECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(WindGenType4IECProjector.class.getName());
}
