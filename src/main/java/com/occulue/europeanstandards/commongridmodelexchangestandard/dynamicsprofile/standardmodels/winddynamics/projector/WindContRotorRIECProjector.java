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
 * Projector for WindContRotorRIEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindContRotorRIEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindContRotorRIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windContRotorRIEC")
@Component("windContRotorRIEC-projector")
public class WindContRotorRIECProjector extends WindContRotorRIECEntityProjector {

  // core constructor
  public WindContRotorRIECProjector(
      WindContRotorRIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindContRotorRIECEvent
   */
  @EventHandler(payloadType = CreateWindContRotorRIECEvent.class)
  public void handle(CreateWindContRotorRIECEvent event) {
    LOGGER.info("handling CreateWindContRotorRIECEvent - " + event);
    WindContRotorRIEC entity = new WindContRotorRIEC();
    entity.setWindContRotorRIECId(event.getWindContRotorRIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event UpdateWindContRotorRIECEvent
   */
  @EventHandler(payloadType = UpdateWindContRotorRIECEvent.class)
  public void handle(UpdateWindContRotorRIECEvent event) {
    LOGGER.info("handling UpdateWindContRotorRIECEvent - " + event);

    WindContRotorRIEC entity = new WindContRotorRIEC();
    entity.setWindContRotorRIECId(event.getWindContRotorRIECId());
    entity.setKirr(event.getKirr());
    entity.setKomegafilt(event.getKomegafilt());
    entity.setKpfilt(event.getKpfilt());
    entity.setKprr(event.getKprr());
    entity.setRmax(event.getRmax());
    entity.setRmin(event.getRmin());
    entity.setTomegafilt(event.getTomegafilt());
    entity.setTpfilt(event.getTpfilt());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event DeleteWindContRotorRIECEvent
   */
  @EventHandler(payloadType = DeleteWindContRotorRIECEvent.class)
  public void handle(DeleteWindContRotorRIECEvent event) {
    LOGGER.info("handling DeleteWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindContRotorRIEC entity = delete(event.getWindContRotorRIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event AssignKirrToWindContRotorRIECEvent
   */
  @EventHandler(payloadType = AssignKirrToWindContRotorRIECEvent.class)
  public void handle(AssignKirrToWindContRotorRIECEvent event) {
    LOGGER.info("handling AssignKirrToWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContRotorRIEC entity = assignKirr(event.getWindContRotorRIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event UnAssignKirrFromWindContRotorRIECEvent
   */
  @EventHandler(payloadType = UnAssignKirrFromWindContRotorRIECEvent.class)
  public void handle(UnAssignKirrFromWindContRotorRIECEvent event) {
    LOGGER.info("handling UnAssignKirrFromWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContRotorRIEC entity = unAssignKirr(event.getWindContRotorRIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event AssignKomegafiltToWindContRotorRIECEvent
   */
  @EventHandler(payloadType = AssignKomegafiltToWindContRotorRIECEvent.class)
  public void handle(AssignKomegafiltToWindContRotorRIECEvent event) {
    LOGGER.info("handling AssignKomegafiltToWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContRotorRIEC entity =
        assignKomegafilt(event.getWindContRotorRIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event UnAssignKomegafiltFromWindContRotorRIECEvent
   */
  @EventHandler(payloadType = UnAssignKomegafiltFromWindContRotorRIECEvent.class)
  public void handle(UnAssignKomegafiltFromWindContRotorRIECEvent event) {
    LOGGER.info("handling UnAssignKomegafiltFromWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContRotorRIEC entity = unAssignKomegafilt(event.getWindContRotorRIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event AssignKpfiltToWindContRotorRIECEvent
   */
  @EventHandler(payloadType = AssignKpfiltToWindContRotorRIECEvent.class)
  public void handle(AssignKpfiltToWindContRotorRIECEvent event) {
    LOGGER.info("handling AssignKpfiltToWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContRotorRIEC entity = assignKpfilt(event.getWindContRotorRIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event UnAssignKpfiltFromWindContRotorRIECEvent
   */
  @EventHandler(payloadType = UnAssignKpfiltFromWindContRotorRIECEvent.class)
  public void handle(UnAssignKpfiltFromWindContRotorRIECEvent event) {
    LOGGER.info("handling UnAssignKpfiltFromWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContRotorRIEC entity = unAssignKpfilt(event.getWindContRotorRIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event AssignKprrToWindContRotorRIECEvent
   */
  @EventHandler(payloadType = AssignKprrToWindContRotorRIECEvent.class)
  public void handle(AssignKprrToWindContRotorRIECEvent event) {
    LOGGER.info("handling AssignKprrToWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContRotorRIEC entity = assignKprr(event.getWindContRotorRIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event UnAssignKprrFromWindContRotorRIECEvent
   */
  @EventHandler(payloadType = UnAssignKprrFromWindContRotorRIECEvent.class)
  public void handle(UnAssignKprrFromWindContRotorRIECEvent event) {
    LOGGER.info("handling UnAssignKprrFromWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContRotorRIEC entity = unAssignKprr(event.getWindContRotorRIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event AssignRmaxToWindContRotorRIECEvent
   */
  @EventHandler(payloadType = AssignRmaxToWindContRotorRIECEvent.class)
  public void handle(AssignRmaxToWindContRotorRIECEvent event) {
    LOGGER.info("handling AssignRmaxToWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContRotorRIEC entity = assignRmax(event.getWindContRotorRIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event UnAssignRmaxFromWindContRotorRIECEvent
   */
  @EventHandler(payloadType = UnAssignRmaxFromWindContRotorRIECEvent.class)
  public void handle(UnAssignRmaxFromWindContRotorRIECEvent event) {
    LOGGER.info("handling UnAssignRmaxFromWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContRotorRIEC entity = unAssignRmax(event.getWindContRotorRIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event AssignRminToWindContRotorRIECEvent
   */
  @EventHandler(payloadType = AssignRminToWindContRotorRIECEvent.class)
  public void handle(AssignRminToWindContRotorRIECEvent event) {
    LOGGER.info("handling AssignRminToWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContRotorRIEC entity = assignRmin(event.getWindContRotorRIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event UnAssignRminFromWindContRotorRIECEvent
   */
  @EventHandler(payloadType = UnAssignRminFromWindContRotorRIECEvent.class)
  public void handle(UnAssignRminFromWindContRotorRIECEvent event) {
    LOGGER.info("handling UnAssignRminFromWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContRotorRIEC entity = unAssignRmin(event.getWindContRotorRIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event AssignTomegafiltToWindContRotorRIECEvent
   */
  @EventHandler(payloadType = AssignTomegafiltToWindContRotorRIECEvent.class)
  public void handle(AssignTomegafiltToWindContRotorRIECEvent event) {
    LOGGER.info("handling AssignTomegafiltToWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContRotorRIEC entity =
        assignTomegafilt(event.getWindContRotorRIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event UnAssignTomegafiltFromWindContRotorRIECEvent
   */
  @EventHandler(payloadType = UnAssignTomegafiltFromWindContRotorRIECEvent.class)
  public void handle(UnAssignTomegafiltFromWindContRotorRIECEvent event) {
    LOGGER.info("handling UnAssignTomegafiltFromWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContRotorRIEC entity = unAssignTomegafilt(event.getWindContRotorRIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event AssignTpfiltToWindContRotorRIECEvent
   */
  @EventHandler(payloadType = AssignTpfiltToWindContRotorRIECEvent.class)
  public void handle(AssignTpfiltToWindContRotorRIECEvent event) {
    LOGGER.info("handling AssignTpfiltToWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContRotorRIEC entity = assignTpfilt(event.getWindContRotorRIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /*
   * @param	event UnAssignTpfiltFromWindContRotorRIECEvent
   */
  @EventHandler(payloadType = UnAssignTpfiltFromWindContRotorRIECEvent.class)
  public void handle(UnAssignTpfiltFromWindContRotorRIECEvent event) {
    LOGGER.info("handling UnAssignTpfiltFromWindContRotorRIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContRotorRIEC entity = unAssignTpfilt(event.getWindContRotorRIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContRotorRIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContRotorRIEC(entity);
  }

  /**
   * Method to retrieve the WindContRotorRIEC via an WindContRotorRIECPrimaryKey.
   *
   * @param id Long
   * @return WindContRotorRIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindContRotorRIEC handle(FindWindContRotorRIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindContRotorRIECId());
  }

  /**
   * Method to retrieve a collection of all WindContRotorRIECs
   *
   * @param query FindAllWindContRotorRIECQuery
   * @return List<WindContRotorRIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindContRotorRIEC> handle(FindAllWindContRotorRIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindContRotorRIEC, but only if the id matches
   *
   * @param entity WindContRotorRIEC
   */
  protected void emitFindWindContRotorRIEC(WindContRotorRIEC entity) {
    LOGGER.info("handling emitFindWindContRotorRIEC");

    queryUpdateEmitter.emit(
        FindWindContRotorRIECQuery.class,
        query -> query.getFilter().getWindContRotorRIECId().equals(entity.getWindContRotorRIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindContRotorRIEC
   *
   * @param entity WindContRotorRIEC
   */
  protected void emitFindAllWindContRotorRIEC(WindContRotorRIEC entity) {
    LOGGER.info("handling emitFindAllWindContRotorRIEC");

    queryUpdateEmitter.emit(FindAllWindContRotorRIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(WindContRotorRIECProjector.class.getName());
}
