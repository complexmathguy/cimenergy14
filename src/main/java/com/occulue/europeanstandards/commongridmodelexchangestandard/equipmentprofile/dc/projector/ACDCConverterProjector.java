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
 * Projector for ACDCConverter as outlined for the CQRS pattern. All event handling and query
 * handling related to ACDCConverter are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by ACDCConverterAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("aCDCConverter")
@Component("aCDCConverter-projector")
public class ACDCConverterProjector extends ACDCConverterEntityProjector {

  // core constructor
  public ACDCConverterProjector(
      ACDCConverterRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateACDCConverterEvent
   */
  @EventHandler(payloadType = CreateACDCConverterEvent.class)
  public void handle(CreateACDCConverterEvent event) {
    LOGGER.info("handling CreateACDCConverterEvent - " + event);
    ACDCConverter entity = new ACDCConverter();
    entity.setACDCConverterId(event.getACDCConverterId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UpdateACDCConverterEvent
   */
  @EventHandler(payloadType = UpdateACDCConverterEvent.class)
  public void handle(UpdateACDCConverterEvent event) {
    LOGGER.info("handling UpdateACDCConverterEvent - " + event);

    ACDCConverter entity = new ACDCConverter();
    entity.setACDCConverterId(event.getACDCConverterId());
    entity.setBaseS(event.getBaseS());
    entity.setIdleLoss(event.getIdleLoss());
    entity.setMaxUdc(event.getMaxUdc());
    entity.setMinUdc(event.getMinUdc());
    entity.setNumberOfValves(event.getNumberOfValves());
    entity.setRatedUdc(event.getRatedUdc());
    entity.setResistiveLoss(event.getResistiveLoss());
    entity.setSwitchingLoss(event.getSwitchingLoss());
    entity.setValveU0(event.getValveU0());
    entity.setConverterDCSides(event.getConverterDCSides());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event DeleteACDCConverterEvent
   */
  @EventHandler(payloadType = DeleteACDCConverterEvent.class)
  public void handle(DeleteACDCConverterEvent event) {
    LOGGER.info("handling DeleteACDCConverterEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ACDCConverter entity = delete(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignBaseSToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignBaseSToACDCConverterEvent.class)
  public void handle(AssignBaseSToACDCConverterEvent event) {
    LOGGER.info("handling AssignBaseSToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCConverter entity = assignBaseS(event.getACDCConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UnAssignBaseSFromACDCConverterEvent
   */
  @EventHandler(payloadType = UnAssignBaseSFromACDCConverterEvent.class)
  public void handle(UnAssignBaseSFromACDCConverterEvent event) {
    LOGGER.info("handling UnAssignBaseSFromACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCConverter entity = unAssignBaseS(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignIdleLossToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignIdleLossToACDCConverterEvent.class)
  public void handle(AssignIdleLossToACDCConverterEvent event) {
    LOGGER.info("handling AssignIdleLossToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCConverter entity = assignIdleLoss(event.getACDCConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UnAssignIdleLossFromACDCConverterEvent
   */
  @EventHandler(payloadType = UnAssignIdleLossFromACDCConverterEvent.class)
  public void handle(UnAssignIdleLossFromACDCConverterEvent event) {
    LOGGER.info("handling UnAssignIdleLossFromACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCConverter entity = unAssignIdleLoss(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignMaxUdcToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignMaxUdcToACDCConverterEvent.class)
  public void handle(AssignMaxUdcToACDCConverterEvent event) {
    LOGGER.info("handling AssignMaxUdcToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCConverter entity = assignMaxUdc(event.getACDCConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UnAssignMaxUdcFromACDCConverterEvent
   */
  @EventHandler(payloadType = UnAssignMaxUdcFromACDCConverterEvent.class)
  public void handle(UnAssignMaxUdcFromACDCConverterEvent event) {
    LOGGER.info("handling UnAssignMaxUdcFromACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCConverter entity = unAssignMaxUdc(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignMinUdcToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignMinUdcToACDCConverterEvent.class)
  public void handle(AssignMinUdcToACDCConverterEvent event) {
    LOGGER.info("handling AssignMinUdcToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCConverter entity = assignMinUdc(event.getACDCConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UnAssignMinUdcFromACDCConverterEvent
   */
  @EventHandler(payloadType = UnAssignMinUdcFromACDCConverterEvent.class)
  public void handle(UnAssignMinUdcFromACDCConverterEvent event) {
    LOGGER.info("handling UnAssignMinUdcFromACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCConverter entity = unAssignMinUdc(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignNumberOfValvesToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignNumberOfValvesToACDCConverterEvent.class)
  public void handle(AssignNumberOfValvesToACDCConverterEvent event) {
    LOGGER.info("handling AssignNumberOfValvesToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCConverter entity = assignNumberOfValves(event.getACDCConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UnAssignNumberOfValvesFromACDCConverterEvent
   */
  @EventHandler(payloadType = UnAssignNumberOfValvesFromACDCConverterEvent.class)
  public void handle(UnAssignNumberOfValvesFromACDCConverterEvent event) {
    LOGGER.info("handling UnAssignNumberOfValvesFromACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCConverter entity = unAssignNumberOfValves(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignRatedUdcToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignRatedUdcToACDCConverterEvent.class)
  public void handle(AssignRatedUdcToACDCConverterEvent event) {
    LOGGER.info("handling AssignRatedUdcToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCConverter entity = assignRatedUdc(event.getACDCConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UnAssignRatedUdcFromACDCConverterEvent
   */
  @EventHandler(payloadType = UnAssignRatedUdcFromACDCConverterEvent.class)
  public void handle(UnAssignRatedUdcFromACDCConverterEvent event) {
    LOGGER.info("handling UnAssignRatedUdcFromACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCConverter entity = unAssignRatedUdc(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignResistiveLossToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignResistiveLossToACDCConverterEvent.class)
  public void handle(AssignResistiveLossToACDCConverterEvent event) {
    LOGGER.info("handling AssignResistiveLossToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCConverter entity = assignResistiveLoss(event.getACDCConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UnAssignResistiveLossFromACDCConverterEvent
   */
  @EventHandler(payloadType = UnAssignResistiveLossFromACDCConverterEvent.class)
  public void handle(UnAssignResistiveLossFromACDCConverterEvent event) {
    LOGGER.info("handling UnAssignResistiveLossFromACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCConverter entity = unAssignResistiveLoss(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignSwitchingLossToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignSwitchingLossToACDCConverterEvent.class)
  public void handle(AssignSwitchingLossToACDCConverterEvent event) {
    LOGGER.info("handling AssignSwitchingLossToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCConverter entity = assignSwitchingLoss(event.getACDCConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UnAssignSwitchingLossFromACDCConverterEvent
   */
  @EventHandler(payloadType = UnAssignSwitchingLossFromACDCConverterEvent.class)
  public void handle(UnAssignSwitchingLossFromACDCConverterEvent event) {
    LOGGER.info("handling UnAssignSwitchingLossFromACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCConverter entity = unAssignSwitchingLoss(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignValveU0ToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignValveU0ToACDCConverterEvent.class)
  public void handle(AssignValveU0ToACDCConverterEvent event) {
    LOGGER.info("handling AssignValveU0ToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCConverter entity = assignValveU0(event.getACDCConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event UnAssignValveU0FromACDCConverterEvent
   */
  @EventHandler(payloadType = UnAssignValveU0FromACDCConverterEvent.class)
  public void handle(UnAssignValveU0FromACDCConverterEvent event) {
    LOGGER.info("handling UnAssignValveU0FromACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCConverter entity = unAssignValveU0(event.getACDCConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event AssignConverterDCSidesToACDCConverterEvent
   */
  @EventHandler(payloadType = AssignConverterDCSidesToACDCConverterEvent.class)
  public void handle(AssignConverterDCSidesToACDCConverterEvent event) {
    LOGGER.info("handling AssignConverterDCSidesToACDCConverterEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    ACDCConverter entity = addToConverterDCSides(event.getACDCConverterId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /*
   * @param	event RemoveConverterDCSidesFromACDCConverterEvent
   */
  @EventHandler(payloadType = RemoveConverterDCSidesFromACDCConverterEvent.class)
  public void handle(RemoveConverterDCSidesFromACDCConverterEvent event) {
    LOGGER.info("handling RemoveConverterDCSidesFromACDCConverterEvent - " + event);

    ACDCConverter entity =
        removeFromConverterDCSides(event.getACDCConverterId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverter(entity);
  }

  /**
   * Method to retrieve the ACDCConverter via an ACDCConverterPrimaryKey.
   *
   * @param id Long
   * @return ACDCConverter
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ACDCConverter handle(FindACDCConverterQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getACDCConverterId());
  }

  /**
   * Method to retrieve a collection of all ACDCConverters
   *
   * @param query FindAllACDCConverterQuery
   * @return List<ACDCConverter>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ACDCConverter> handle(FindAllACDCConverterQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindACDCConverter, but only if the id matches
   *
   * @param entity ACDCConverter
   */
  protected void emitFindACDCConverter(ACDCConverter entity) {
    LOGGER.info("handling emitFindACDCConverter");

    queryUpdateEmitter.emit(
        FindACDCConverterQuery.class,
        query -> query.getFilter().getACDCConverterId().equals(entity.getACDCConverterId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllACDCConverter
   *
   * @param entity ACDCConverter
   */
  protected void emitFindAllACDCConverter(ACDCConverter entity) {
    LOGGER.info("handling emitFindAllACDCConverter");

    queryUpdateEmitter.emit(FindAllACDCConverterQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ACDCConverterProjector.class.getName());
}
