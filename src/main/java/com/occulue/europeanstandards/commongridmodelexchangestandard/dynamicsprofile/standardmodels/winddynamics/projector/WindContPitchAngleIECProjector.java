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
 * Projector for WindContPitchAngleIEC as outlined for the CQRS pattern. All event handling and
 * query handling related to WindContPitchAngleIEC are invoked here and dispersed as an event to be
 * handled elsewhere.
 *
 * <p>Commands are handled by WindContPitchAngleIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windContPitchAngleIEC")
@Component("windContPitchAngleIEC-projector")
public class WindContPitchAngleIECProjector extends WindContPitchAngleIECEntityProjector {

  // core constructor
  public WindContPitchAngleIECProjector(
      WindContPitchAngleIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = CreateWindContPitchAngleIECEvent.class)
  public void handle(CreateWindContPitchAngleIECEvent event) {
    LOGGER.info("handling CreateWindContPitchAngleIECEvent - " + event);
    WindContPitchAngleIEC entity = new WindContPitchAngleIEC();
    entity.setWindContPitchAngleIECId(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UpdateWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UpdateWindContPitchAngleIECEvent.class)
  public void handle(UpdateWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UpdateWindContPitchAngleIECEvent - " + event);

    WindContPitchAngleIEC entity = new WindContPitchAngleIEC();
    entity.setWindContPitchAngleIECId(event.getWindContPitchAngleIECId());
    entity.setDthetamax(event.getDthetamax());
    entity.setDthetamin(event.getDthetamin());
    entity.setKic(event.getKic());
    entity.setKiomega(event.getKiomega());
    entity.setKpc(event.getKpc());
    entity.setKpomega(event.getKpomega());
    entity.setKpx(event.getKpx());
    entity.setThetamax(event.getThetamax());
    entity.setThetamin(event.getThetamin());
    entity.setTtheta(event.getTtheta());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event DeleteWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = DeleteWindContPitchAngleIECEvent.class)
  public void handle(DeleteWindContPitchAngleIECEvent event) {
    LOGGER.info("handling DeleteWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindContPitchAngleIEC entity = delete(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignDthetamaxToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignDthetamaxToWindContPitchAngleIECEvent.class)
  public void handle(AssignDthetamaxToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignDthetamaxToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignDthetamax(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignDthetamaxFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignDthetamaxFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignDthetamaxFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignDthetamaxFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignDthetamax(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignDthetaminToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignDthetaminToWindContPitchAngleIECEvent.class)
  public void handle(AssignDthetaminToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignDthetaminToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignDthetamin(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignDthetaminFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignDthetaminFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignDthetaminFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignDthetaminFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignDthetamin(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignKicToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignKicToWindContPitchAngleIECEvent.class)
  public void handle(AssignKicToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignKicToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignKic(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignKicFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignKicFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignKicFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignKicFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignKic(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignKiomegaToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignKiomegaToWindContPitchAngleIECEvent.class)
  public void handle(AssignKiomegaToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignKiomegaToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignKiomega(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignKiomegaFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignKiomegaFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignKiomegaFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignKiomegaFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignKiomega(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignKpcToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignKpcToWindContPitchAngleIECEvent.class)
  public void handle(AssignKpcToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignKpcToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignKpc(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignKpcFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignKpcFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignKpcFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignKpcFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignKpc(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignKpomegaToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignKpomegaToWindContPitchAngleIECEvent.class)
  public void handle(AssignKpomegaToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignKpomegaToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignKpomega(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignKpomegaFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignKpomegaFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignKpomegaFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignKpomegaFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignKpomega(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignKpxToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignKpxToWindContPitchAngleIECEvent.class)
  public void handle(AssignKpxToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignKpxToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignKpx(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignKpxFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignKpxFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignKpxFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignKpxFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignKpx(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignThetamaxToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignThetamaxToWindContPitchAngleIECEvent.class)
  public void handle(AssignThetamaxToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignThetamaxToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignThetamax(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignThetamaxFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignThetamaxFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignThetamaxFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignThetamaxFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignThetamax(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignThetaminToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignThetaminToWindContPitchAngleIECEvent.class)
  public void handle(AssignThetaminToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignThetaminToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignThetamin(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignThetaminFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignThetaminFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignThetaminFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignThetaminFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignThetamin(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event AssignTthetaToWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = AssignTthetaToWindContPitchAngleIECEvent.class)
  public void handle(AssignTthetaToWindContPitchAngleIECEvent event) {
    LOGGER.info("handling AssignTthetaToWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPitchAngleIEC entity =
        assignTtheta(event.getWindContPitchAngleIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /*
   * @param	event UnAssignTthetaFromWindContPitchAngleIECEvent
   */
  @EventHandler(payloadType = UnAssignTthetaFromWindContPitchAngleIECEvent.class)
  public void handle(UnAssignTthetaFromWindContPitchAngleIECEvent event) {
    LOGGER.info("handling UnAssignTthetaFromWindContPitchAngleIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPitchAngleIEC entity = unAssignTtheta(event.getWindContPitchAngleIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPitchAngleIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPitchAngleIEC(entity);
  }

  /**
   * Method to retrieve the WindContPitchAngleIEC via an WindContPitchAngleIECPrimaryKey.
   *
   * @param id Long
   * @return WindContPitchAngleIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindContPitchAngleIEC handle(FindWindContPitchAngleIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindContPitchAngleIECId());
  }

  /**
   * Method to retrieve a collection of all WindContPitchAngleIECs
   *
   * @param query FindAllWindContPitchAngleIECQuery
   * @return List<WindContPitchAngleIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindContPitchAngleIEC> handle(FindAllWindContPitchAngleIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindContPitchAngleIEC, but only if the id matches
   *
   * @param entity WindContPitchAngleIEC
   */
  protected void emitFindWindContPitchAngleIEC(WindContPitchAngleIEC entity) {
    LOGGER.info("handling emitFindWindContPitchAngleIEC");

    queryUpdateEmitter.emit(
        FindWindContPitchAngleIECQuery.class,
        query ->
            query
                .getFilter()
                .getWindContPitchAngleIECId()
                .equals(entity.getWindContPitchAngleIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindContPitchAngleIEC
   *
   * @param entity WindContPitchAngleIEC
   */
  protected void emitFindAllWindContPitchAngleIEC(WindContPitchAngleIEC entity) {
    LOGGER.info("handling emitFindAllWindContPitchAngleIEC");

    queryUpdateEmitter.emit(FindAllWindContPitchAngleIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindContPitchAngleIECProjector.class.getName());
}
