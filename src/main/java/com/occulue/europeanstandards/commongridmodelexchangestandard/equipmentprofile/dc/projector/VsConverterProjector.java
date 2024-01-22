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
 * Projector for VsConverter as outlined for the CQRS pattern. All event handling and query handling
 * related to VsConverter are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by VsConverterAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("vsConverter")
@Component("vsConverter-projector")
public class VsConverterProjector extends VsConverterEntityProjector {

  // core constructor
  public VsConverterProjector(
      VsConverterRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateVsConverterEvent
   */
  @EventHandler(payloadType = CreateVsConverterEvent.class)
  public void handle(CreateVsConverterEvent event) {
    LOGGER.info("handling CreateVsConverterEvent - " + event);
    VsConverter entity = new VsConverter();
    entity.setVsConverterId(event.getVsConverterId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVsConverter(entity);
  }

  /*
   * @param	event UpdateVsConverterEvent
   */
  @EventHandler(payloadType = UpdateVsConverterEvent.class)
  public void handle(UpdateVsConverterEvent event) {
    LOGGER.info("handling UpdateVsConverterEvent - " + event);

    VsConverter entity = new VsConverter();
    entity.setVsConverterId(event.getVsConverterId());
    entity.setMaxModulationIndex(event.getMaxModulationIndex());
    entity.setMaxValveCurrent(event.getMaxValveCurrent());
    entity.setVsConverterDCSides(event.getVsConverterDCSides());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVsConverter(entity);
  }

  /*
   * @param	event DeleteVsConverterEvent
   */
  @EventHandler(payloadType = DeleteVsConverterEvent.class)
  public void handle(DeleteVsConverterEvent event) {
    LOGGER.info("handling DeleteVsConverterEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    VsConverter entity = delete(event.getVsConverterId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVsConverter(entity);
  }

  /*
   * @param	event AssignMaxModulationIndexToVsConverterEvent
   */
  @EventHandler(payloadType = AssignMaxModulationIndexToVsConverterEvent.class)
  public void handle(AssignMaxModulationIndexToVsConverterEvent event) {
    LOGGER.info("handling AssignMaxModulationIndexToVsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    VsConverter entity = assignMaxModulationIndex(event.getVsConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVsConverter(entity);
  }

  /*
   * @param	event UnAssignMaxModulationIndexFromVsConverterEvent
   */
  @EventHandler(payloadType = UnAssignMaxModulationIndexFromVsConverterEvent.class)
  public void handle(UnAssignMaxModulationIndexFromVsConverterEvent event) {
    LOGGER.info("handling UnAssignMaxModulationIndexFromVsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    VsConverter entity = unAssignMaxModulationIndex(event.getVsConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVsConverter(entity);
  }

  /*
   * @param	event AssignMaxValveCurrentToVsConverterEvent
   */
  @EventHandler(payloadType = AssignMaxValveCurrentToVsConverterEvent.class)
  public void handle(AssignMaxValveCurrentToVsConverterEvent event) {
    LOGGER.info("handling AssignMaxValveCurrentToVsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    VsConverter entity = assignMaxValveCurrent(event.getVsConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVsConverter(entity);
  }

  /*
   * @param	event UnAssignMaxValveCurrentFromVsConverterEvent
   */
  @EventHandler(payloadType = UnAssignMaxValveCurrentFromVsConverterEvent.class)
  public void handle(UnAssignMaxValveCurrentFromVsConverterEvent event) {
    LOGGER.info("handling UnAssignMaxValveCurrentFromVsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    VsConverter entity = unAssignMaxValveCurrent(event.getVsConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVsConverter(entity);
  }

  /*
   * @param	event AssignVsConverterDCSidesToVsConverterEvent
   */
  @EventHandler(payloadType = AssignVsConverterDCSidesToVsConverterEvent.class)
  public void handle(AssignVsConverterDCSidesToVsConverterEvent event) {
    LOGGER.info("handling AssignVsConverterDCSidesToVsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    VsConverter entity = addToVsConverterDCSides(event.getVsConverterId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVsConverter(entity);
  }

  /*
   * @param	event RemoveVsConverterDCSidesFromVsConverterEvent
   */
  @EventHandler(payloadType = RemoveVsConverterDCSidesFromVsConverterEvent.class)
  public void handle(RemoveVsConverterDCSidesFromVsConverterEvent event) {
    LOGGER.info("handling RemoveVsConverterDCSidesFromVsConverterEvent - " + event);

    VsConverter entity =
        removeFromVsConverterDCSides(event.getVsConverterId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVsConverter(entity);
  }

  /**
   * Method to retrieve the VsConverter via an VsConverterPrimaryKey.
   *
   * @param id Long
   * @return VsConverter
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public VsConverter handle(FindVsConverterQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getVsConverterId());
  }

  /**
   * Method to retrieve a collection of all VsConverters
   *
   * @param query FindAllVsConverterQuery
   * @return List<VsConverter>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<VsConverter> handle(FindAllVsConverterQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindVsConverter, but only if the id matches
   *
   * @param entity VsConverter
   */
  protected void emitFindVsConverter(VsConverter entity) {
    LOGGER.info("handling emitFindVsConverter");

    queryUpdateEmitter.emit(
        FindVsConverterQuery.class,
        query -> query.getFilter().getVsConverterId().equals(entity.getVsConverterId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllVsConverter
   *
   * @param entity VsConverter
   */
  protected void emitFindAllVsConverter(VsConverter entity) {
    LOGGER.info("handling emitFindAllVsConverter");

    queryUpdateEmitter.emit(FindAllVsConverterQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(VsConverterProjector.class.getName());
}
