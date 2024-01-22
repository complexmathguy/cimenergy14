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
 * Projector for WindAeroLinearIEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindAeroLinearIEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindAeroLinearIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windAeroLinearIEC")
@Component("windAeroLinearIEC-projector")
public class WindAeroLinearIECProjector extends WindAeroLinearIECEntityProjector {

  // core constructor
  public WindAeroLinearIECProjector(
      WindAeroLinearIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = CreateWindAeroLinearIECEvent.class)
  public void handle(CreateWindAeroLinearIECEvent event) {
    LOGGER.info("handling CreateWindAeroLinearIECEvent - " + event);
    WindAeroLinearIEC entity = new WindAeroLinearIEC();
    entity.setWindAeroLinearIECId(event.getWindAeroLinearIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event UpdateWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = UpdateWindAeroLinearIECEvent.class)
  public void handle(UpdateWindAeroLinearIECEvent event) {
    LOGGER.info("handling UpdateWindAeroLinearIECEvent - " + event);

    WindAeroLinearIEC entity = new WindAeroLinearIEC();
    entity.setWindAeroLinearIECId(event.getWindAeroLinearIECId());
    entity.setDpomega(event.getDpomega());
    entity.setDptheta(event.getDptheta());
    entity.setOmegazero(event.getOmegazero());
    entity.setPavail(event.getPavail());
    entity.setThetazero(event.getThetazero());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event DeleteWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = DeleteWindAeroLinearIECEvent.class)
  public void handle(DeleteWindAeroLinearIECEvent event) {
    LOGGER.info("handling DeleteWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindAeroLinearIEC entity = delete(event.getWindAeroLinearIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event AssignDpomegaToWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = AssignDpomegaToWindAeroLinearIECEvent.class)
  public void handle(AssignDpomegaToWindAeroLinearIECEvent event) {
    LOGGER.info("handling AssignDpomegaToWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindAeroLinearIEC entity = assignDpomega(event.getWindAeroLinearIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event UnAssignDpomegaFromWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = UnAssignDpomegaFromWindAeroLinearIECEvent.class)
  public void handle(UnAssignDpomegaFromWindAeroLinearIECEvent event) {
    LOGGER.info("handling UnAssignDpomegaFromWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindAeroLinearIEC entity = unAssignDpomega(event.getWindAeroLinearIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event AssignDpthetaToWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = AssignDpthetaToWindAeroLinearIECEvent.class)
  public void handle(AssignDpthetaToWindAeroLinearIECEvent event) {
    LOGGER.info("handling AssignDpthetaToWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindAeroLinearIEC entity = assignDptheta(event.getWindAeroLinearIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event UnAssignDpthetaFromWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = UnAssignDpthetaFromWindAeroLinearIECEvent.class)
  public void handle(UnAssignDpthetaFromWindAeroLinearIECEvent event) {
    LOGGER.info("handling UnAssignDpthetaFromWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindAeroLinearIEC entity = unAssignDptheta(event.getWindAeroLinearIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event AssignOmegazeroToWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = AssignOmegazeroToWindAeroLinearIECEvent.class)
  public void handle(AssignOmegazeroToWindAeroLinearIECEvent event) {
    LOGGER.info("handling AssignOmegazeroToWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindAeroLinearIEC entity =
        assignOmegazero(event.getWindAeroLinearIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event UnAssignOmegazeroFromWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = UnAssignOmegazeroFromWindAeroLinearIECEvent.class)
  public void handle(UnAssignOmegazeroFromWindAeroLinearIECEvent event) {
    LOGGER.info("handling UnAssignOmegazeroFromWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindAeroLinearIEC entity = unAssignOmegazero(event.getWindAeroLinearIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event AssignPavailToWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = AssignPavailToWindAeroLinearIECEvent.class)
  public void handle(AssignPavailToWindAeroLinearIECEvent event) {
    LOGGER.info("handling AssignPavailToWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindAeroLinearIEC entity = assignPavail(event.getWindAeroLinearIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event UnAssignPavailFromWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = UnAssignPavailFromWindAeroLinearIECEvent.class)
  public void handle(UnAssignPavailFromWindAeroLinearIECEvent event) {
    LOGGER.info("handling UnAssignPavailFromWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindAeroLinearIEC entity = unAssignPavail(event.getWindAeroLinearIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event AssignThetazeroToWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = AssignThetazeroToWindAeroLinearIECEvent.class)
  public void handle(AssignThetazeroToWindAeroLinearIECEvent event) {
    LOGGER.info("handling AssignThetazeroToWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindAeroLinearIEC entity =
        assignThetazero(event.getWindAeroLinearIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /*
   * @param	event UnAssignThetazeroFromWindAeroLinearIECEvent
   */
  @EventHandler(payloadType = UnAssignThetazeroFromWindAeroLinearIECEvent.class)
  public void handle(UnAssignThetazeroFromWindAeroLinearIECEvent event) {
    LOGGER.info("handling UnAssignThetazeroFromWindAeroLinearIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindAeroLinearIEC entity = unAssignThetazero(event.getWindAeroLinearIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindAeroLinearIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindAeroLinearIEC(entity);
  }

  /**
   * Method to retrieve the WindAeroLinearIEC via an WindAeroLinearIECPrimaryKey.
   *
   * @param id Long
   * @return WindAeroLinearIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindAeroLinearIEC handle(FindWindAeroLinearIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindAeroLinearIECId());
  }

  /**
   * Method to retrieve a collection of all WindAeroLinearIECs
   *
   * @param query FindAllWindAeroLinearIECQuery
   * @return List<WindAeroLinearIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindAeroLinearIEC> handle(FindAllWindAeroLinearIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindAeroLinearIEC, but only if the id matches
   *
   * @param entity WindAeroLinearIEC
   */
  protected void emitFindWindAeroLinearIEC(WindAeroLinearIEC entity) {
    LOGGER.info("handling emitFindWindAeroLinearIEC");

    queryUpdateEmitter.emit(
        FindWindAeroLinearIECQuery.class,
        query -> query.getFilter().getWindAeroLinearIECId().equals(entity.getWindAeroLinearIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindAeroLinearIEC
   *
   * @param entity WindAeroLinearIEC
   */
  protected void emitFindAllWindAeroLinearIEC(WindAeroLinearIEC entity) {
    LOGGER.info("handling emitFindAllWindAeroLinearIEC");

    queryUpdateEmitter.emit(FindAllWindAeroLinearIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(WindAeroLinearIECProjector.class.getName());
}
