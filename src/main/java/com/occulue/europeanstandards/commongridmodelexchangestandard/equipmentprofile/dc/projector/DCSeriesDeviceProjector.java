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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for DCSeriesDevice as outlined for the CQRS pattern. All event handling and query
 * handling related to DCSeriesDevice are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by DCSeriesDeviceAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("dCSeriesDevice")
@Component("dCSeriesDevice-projector")
public class DCSeriesDeviceProjector extends DCSeriesDeviceEntityProjector {

  // core constructor
  public DCSeriesDeviceProjector(
      DCSeriesDeviceRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateDCSeriesDeviceEvent
   */
  @EventHandler(payloadType = CreateDCSeriesDeviceEvent.class)
  public void handle(CreateDCSeriesDeviceEvent event) {
    LOGGER.info("handling CreateDCSeriesDeviceEvent - " + event);
    DCSeriesDevice entity = new DCSeriesDevice();
    entity.setDCSeriesDeviceId(event.getDCSeriesDeviceId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCSeriesDevice(entity);
  }

  /*
   * @param	event UpdateDCSeriesDeviceEvent
   */
  @EventHandler(payloadType = UpdateDCSeriesDeviceEvent.class)
  public void handle(UpdateDCSeriesDeviceEvent event) {
    LOGGER.info("handling UpdateDCSeriesDeviceEvent - " + event);

    DCSeriesDevice entity = new DCSeriesDevice();
    entity.setDCSeriesDeviceId(event.getDCSeriesDeviceId());
    entity.setInductance(event.getInductance());
    entity.setRatedUdc(event.getRatedUdc());
    entity.setResistance(event.getResistance());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCSeriesDevice(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCSeriesDevice(entity);
  }

  /*
   * @param	event DeleteDCSeriesDeviceEvent
   */
  @EventHandler(payloadType = DeleteDCSeriesDeviceEvent.class)
  public void handle(DeleteDCSeriesDeviceEvent event) {
    LOGGER.info("handling DeleteDCSeriesDeviceEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    DCSeriesDevice entity = delete(event.getDCSeriesDeviceId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCSeriesDevice(entity);
  }

  /*
   * @param	event AssignInductanceToDCSeriesDeviceEvent
   */
  @EventHandler(payloadType = AssignInductanceToDCSeriesDeviceEvent.class)
  public void handle(AssignInductanceToDCSeriesDeviceEvent event) {
    LOGGER.info("handling AssignInductanceToDCSeriesDeviceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DCSeriesDevice entity = assignInductance(event.getDCSeriesDeviceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCSeriesDevice(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCSeriesDevice(entity);
  }

  /*
   * @param	event UnAssignInductanceFromDCSeriesDeviceEvent
   */
  @EventHandler(payloadType = UnAssignInductanceFromDCSeriesDeviceEvent.class)
  public void handle(UnAssignInductanceFromDCSeriesDeviceEvent event) {
    LOGGER.info("handling UnAssignInductanceFromDCSeriesDeviceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DCSeriesDevice entity = unAssignInductance(event.getDCSeriesDeviceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCSeriesDevice(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCSeriesDevice(entity);
  }

  /*
   * @param	event AssignRatedUdcToDCSeriesDeviceEvent
   */
  @EventHandler(payloadType = AssignRatedUdcToDCSeriesDeviceEvent.class)
  public void handle(AssignRatedUdcToDCSeriesDeviceEvent event) {
    LOGGER.info("handling AssignRatedUdcToDCSeriesDeviceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DCSeriesDevice entity = assignRatedUdc(event.getDCSeriesDeviceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCSeriesDevice(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCSeriesDevice(entity);
  }

  /*
   * @param	event UnAssignRatedUdcFromDCSeriesDeviceEvent
   */
  @EventHandler(payloadType = UnAssignRatedUdcFromDCSeriesDeviceEvent.class)
  public void handle(UnAssignRatedUdcFromDCSeriesDeviceEvent event) {
    LOGGER.info("handling UnAssignRatedUdcFromDCSeriesDeviceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DCSeriesDevice entity = unAssignRatedUdc(event.getDCSeriesDeviceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCSeriesDevice(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCSeriesDevice(entity);
  }

  /*
   * @param	event AssignResistanceToDCSeriesDeviceEvent
   */
  @EventHandler(payloadType = AssignResistanceToDCSeriesDeviceEvent.class)
  public void handle(AssignResistanceToDCSeriesDeviceEvent event) {
    LOGGER.info("handling AssignResistanceToDCSeriesDeviceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DCSeriesDevice entity = assignResistance(event.getDCSeriesDeviceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCSeriesDevice(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCSeriesDevice(entity);
  }

  /*
   * @param	event UnAssignResistanceFromDCSeriesDeviceEvent
   */
  @EventHandler(payloadType = UnAssignResistanceFromDCSeriesDeviceEvent.class)
  public void handle(UnAssignResistanceFromDCSeriesDeviceEvent event) {
    LOGGER.info("handling UnAssignResistanceFromDCSeriesDeviceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DCSeriesDevice entity = unAssignResistance(event.getDCSeriesDeviceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCSeriesDevice(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCSeriesDevice(entity);
  }

  /**
   * Method to retrieve the DCSeriesDevice via an DCSeriesDevicePrimaryKey.
   *
   * @param id Long
   * @return DCSeriesDevice
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public DCSeriesDevice handle(FindDCSeriesDeviceQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getDCSeriesDeviceId());
  }

  /**
   * Method to retrieve a collection of all DCSeriesDevices
   *
   * @param query FindAllDCSeriesDeviceQuery
   * @return List<DCSeriesDevice>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<DCSeriesDevice> handle(FindAllDCSeriesDeviceQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindDCSeriesDevice, but only if the id matches
   *
   * @param entity DCSeriesDevice
   */
  protected void emitFindDCSeriesDevice(DCSeriesDevice entity) {
    LOGGER.info("handling emitFindDCSeriesDevice");

    queryUpdateEmitter.emit(
        FindDCSeriesDeviceQuery.class,
        query -> query.getFilter().getDCSeriesDeviceId().equals(entity.getDCSeriesDeviceId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllDCSeriesDevice
   *
   * @param entity DCSeriesDevice
   */
  protected void emitFindAllDCSeriesDevice(DCSeriesDevice entity) {
    LOGGER.info("handling emitFindAllDCSeriesDevice");

    queryUpdateEmitter.emit(FindAllDCSeriesDeviceQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(DCSeriesDeviceProjector.class.getName());
}
