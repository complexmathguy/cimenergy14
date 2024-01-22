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
 * Projector for WindMechIEC as outlined for the CQRS pattern. All event handling and query handling
 * related to WindMechIEC are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by WindMechIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windMechIEC")
@Component("windMechIEC-projector")
public class WindMechIECProjector extends WindMechIECEntityProjector {

  // core constructor
  public WindMechIECProjector(
      WindMechIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindMechIECEvent
   */
  @EventHandler(payloadType = CreateWindMechIECEvent.class)
  public void handle(CreateWindMechIECEvent event) {
    LOGGER.info("handling CreateWindMechIECEvent - " + event);
    WindMechIEC entity = new WindMechIEC();
    entity.setWindMechIECId(event.getWindMechIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event UpdateWindMechIECEvent
   */
  @EventHandler(payloadType = UpdateWindMechIECEvent.class)
  public void handle(UpdateWindMechIECEvent event) {
    LOGGER.info("handling UpdateWindMechIECEvent - " + event);

    WindMechIEC entity = new WindMechIEC();
    entity.setWindMechIECId(event.getWindMechIECId());
    entity.setCdrt(event.getCdrt());
    entity.setHgen(event.getHgen());
    entity.setHwtr(event.getHwtr());
    entity.setKdrt(event.getKdrt());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindMechIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event DeleteWindMechIECEvent
   */
  @EventHandler(payloadType = DeleteWindMechIECEvent.class)
  public void handle(DeleteWindMechIECEvent event) {
    LOGGER.info("handling DeleteWindMechIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindMechIEC entity = delete(event.getWindMechIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event AssignCdrtToWindMechIECEvent
   */
  @EventHandler(payloadType = AssignCdrtToWindMechIECEvent.class)
  public void handle(AssignCdrtToWindMechIECEvent event) {
    LOGGER.info("handling AssignCdrtToWindMechIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindMechIEC entity = assignCdrt(event.getWindMechIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindMechIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event UnAssignCdrtFromWindMechIECEvent
   */
  @EventHandler(payloadType = UnAssignCdrtFromWindMechIECEvent.class)
  public void handle(UnAssignCdrtFromWindMechIECEvent event) {
    LOGGER.info("handling UnAssignCdrtFromWindMechIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindMechIEC entity = unAssignCdrt(event.getWindMechIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindMechIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event AssignHgenToWindMechIECEvent
   */
  @EventHandler(payloadType = AssignHgenToWindMechIECEvent.class)
  public void handle(AssignHgenToWindMechIECEvent event) {
    LOGGER.info("handling AssignHgenToWindMechIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindMechIEC entity = assignHgen(event.getWindMechIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindMechIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event UnAssignHgenFromWindMechIECEvent
   */
  @EventHandler(payloadType = UnAssignHgenFromWindMechIECEvent.class)
  public void handle(UnAssignHgenFromWindMechIECEvent event) {
    LOGGER.info("handling UnAssignHgenFromWindMechIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindMechIEC entity = unAssignHgen(event.getWindMechIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindMechIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event AssignHwtrToWindMechIECEvent
   */
  @EventHandler(payloadType = AssignHwtrToWindMechIECEvent.class)
  public void handle(AssignHwtrToWindMechIECEvent event) {
    LOGGER.info("handling AssignHwtrToWindMechIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindMechIEC entity = assignHwtr(event.getWindMechIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindMechIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event UnAssignHwtrFromWindMechIECEvent
   */
  @EventHandler(payloadType = UnAssignHwtrFromWindMechIECEvent.class)
  public void handle(UnAssignHwtrFromWindMechIECEvent event) {
    LOGGER.info("handling UnAssignHwtrFromWindMechIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindMechIEC entity = unAssignHwtr(event.getWindMechIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindMechIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event AssignKdrtToWindMechIECEvent
   */
  @EventHandler(payloadType = AssignKdrtToWindMechIECEvent.class)
  public void handle(AssignKdrtToWindMechIECEvent event) {
    LOGGER.info("handling AssignKdrtToWindMechIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindMechIEC entity = assignKdrt(event.getWindMechIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindMechIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /*
   * @param	event UnAssignKdrtFromWindMechIECEvent
   */
  @EventHandler(payloadType = UnAssignKdrtFromWindMechIECEvent.class)
  public void handle(UnAssignKdrtFromWindMechIECEvent event) {
    LOGGER.info("handling UnAssignKdrtFromWindMechIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindMechIEC entity = unAssignKdrt(event.getWindMechIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindMechIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindMechIEC(entity);
  }

  /**
   * Method to retrieve the WindMechIEC via an WindMechIECPrimaryKey.
   *
   * @param id Long
   * @return WindMechIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindMechIEC handle(FindWindMechIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindMechIECId());
  }

  /**
   * Method to retrieve a collection of all WindMechIECs
   *
   * @param query FindAllWindMechIECQuery
   * @return List<WindMechIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindMechIEC> handle(FindAllWindMechIECQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindMechIEC, but only if the id matches
   *
   * @param entity WindMechIEC
   */
  protected void emitFindWindMechIEC(WindMechIEC entity) {
    LOGGER.info("handling emitFindWindMechIEC");

    queryUpdateEmitter.emit(
        FindWindMechIECQuery.class,
        query -> query.getFilter().getWindMechIECId().equals(entity.getWindMechIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindMechIEC
   *
   * @param entity WindMechIEC
   */
  protected void emitFindAllWindMechIEC(WindMechIEC entity) {
    LOGGER.info("handling emitFindAllWindMechIEC");

    queryUpdateEmitter.emit(FindAllWindMechIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(WindMechIECProjector.class.getName());
}
