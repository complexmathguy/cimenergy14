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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for BusNameMarker as outlined for the CQRS pattern. All event handling and query
 * handling related to BusNameMarker are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by BusNameMarkerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("busNameMarker")
@Component("busNameMarker-projector")
public class BusNameMarkerProjector extends BusNameMarkerEntityProjector {

  // core constructor
  public BusNameMarkerProjector(
      BusNameMarkerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateBusNameMarkerEvent
   */
  @EventHandler(payloadType = CreateBusNameMarkerEvent.class)
  public void handle(CreateBusNameMarkerEvent event) {
    LOGGER.info("handling CreateBusNameMarkerEvent - " + event);
    BusNameMarker entity = new BusNameMarker();
    entity.setBusNameMarkerId(event.getBusNameMarkerId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBusNameMarker(entity);
  }

  /*
   * @param	event UpdateBusNameMarkerEvent
   */
  @EventHandler(payloadType = UpdateBusNameMarkerEvent.class)
  public void handle(UpdateBusNameMarkerEvent event) {
    LOGGER.info("handling UpdateBusNameMarkerEvent - " + event);

    BusNameMarker entity = new BusNameMarker();
    entity.setBusNameMarkerId(event.getBusNameMarkerId());
    entity.setPriority(event.getPriority());
    entity.setBusNameMarker(event.getBusNameMarker());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBusNameMarker(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBusNameMarker(entity);
  }

  /*
   * @param	event DeleteBusNameMarkerEvent
   */
  @EventHandler(payloadType = DeleteBusNameMarkerEvent.class)
  public void handle(DeleteBusNameMarkerEvent event) {
    LOGGER.info("handling DeleteBusNameMarkerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    BusNameMarker entity = delete(event.getBusNameMarkerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBusNameMarker(entity);
  }

  /*
   * @param	event AssignPriorityToBusNameMarkerEvent
   */
  @EventHandler(payloadType = AssignPriorityToBusNameMarkerEvent.class)
  public void handle(AssignPriorityToBusNameMarkerEvent event) {
    LOGGER.info("handling AssignPriorityToBusNameMarkerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    BusNameMarker entity = assignPriority(event.getBusNameMarkerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBusNameMarker(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBusNameMarker(entity);
  }

  /*
   * @param	event UnAssignPriorityFromBusNameMarkerEvent
   */
  @EventHandler(payloadType = UnAssignPriorityFromBusNameMarkerEvent.class)
  public void handle(UnAssignPriorityFromBusNameMarkerEvent event) {
    LOGGER.info("handling UnAssignPriorityFromBusNameMarkerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    BusNameMarker entity = unAssignPriority(event.getBusNameMarkerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBusNameMarker(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBusNameMarker(entity);
  }

  /*
   * @param	event AssignBusNameMarkerToBusNameMarkerEvent
   */
  @EventHandler(payloadType = AssignBusNameMarkerToBusNameMarkerEvent.class)
  public void handle(AssignBusNameMarkerToBusNameMarkerEvent event) {
    LOGGER.info("handling AssignBusNameMarkerToBusNameMarkerEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    BusNameMarker entity = addToBusNameMarker(event.getBusNameMarkerId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBusNameMarker(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBusNameMarker(entity);
  }

  /*
   * @param	event RemoveBusNameMarkerFromBusNameMarkerEvent
   */
  @EventHandler(payloadType = RemoveBusNameMarkerFromBusNameMarkerEvent.class)
  public void handle(RemoveBusNameMarkerFromBusNameMarkerEvent event) {
    LOGGER.info("handling RemoveBusNameMarkerFromBusNameMarkerEvent - " + event);

    BusNameMarker entity =
        removeFromBusNameMarker(event.getBusNameMarkerId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBusNameMarker(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBusNameMarker(entity);
  }

  /**
   * Method to retrieve the BusNameMarker via an BusNameMarkerPrimaryKey.
   *
   * @param id Long
   * @return BusNameMarker
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public BusNameMarker handle(FindBusNameMarkerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getBusNameMarkerId());
  }

  /**
   * Method to retrieve a collection of all BusNameMarkers
   *
   * @param query FindAllBusNameMarkerQuery
   * @return List<BusNameMarker>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<BusNameMarker> handle(FindAllBusNameMarkerQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindBusNameMarker, but only if the id matches
   *
   * @param entity BusNameMarker
   */
  protected void emitFindBusNameMarker(BusNameMarker entity) {
    LOGGER.info("handling emitFindBusNameMarker");

    queryUpdateEmitter.emit(
        FindBusNameMarkerQuery.class,
        query -> query.getFilter().getBusNameMarkerId().equals(entity.getBusNameMarkerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllBusNameMarker
   *
   * @param entity BusNameMarker
   */
  protected void emitFindAllBusNameMarker(BusNameMarker entity) {
    LOGGER.info("handling emitFindAllBusNameMarker");

    queryUpdateEmitter.emit(FindAllBusNameMarkerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(BusNameMarkerProjector.class.getName());
}
