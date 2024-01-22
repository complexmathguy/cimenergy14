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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for EquivalentInjection as outlined for the CQRS pattern. All event handling and query
 * handling related to EquivalentInjection are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by EquivalentInjectionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("equivalentInjection")
@Component("equivalentInjection-projector")
public class EquivalentInjectionProjector extends EquivalentInjectionEntityProjector {

  // core constructor
  public EquivalentInjectionProjector(
      EquivalentInjectionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateEquivalentInjectionEvent
   */
  @EventHandler(payloadType = CreateEquivalentInjectionEvent.class)
  public void handle(CreateEquivalentInjectionEvent event) {
    LOGGER.info("handling CreateEquivalentInjectionEvent - " + event);
    EquivalentInjection entity = new EquivalentInjection();
    entity.setEquivalentInjectionId(event.getEquivalentInjectionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UpdateEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UpdateEquivalentInjectionEvent.class)
  public void handle(UpdateEquivalentInjectionEvent event) {
    LOGGER.info("handling UpdateEquivalentInjectionEvent - " + event);

    EquivalentInjection entity = new EquivalentInjection();
    entity.setEquivalentInjectionId(event.getEquivalentInjectionId());
    entity.setMaxP(event.getMaxP());
    entity.setMaxQ(event.getMaxQ());
    entity.setMinP(event.getMinP());
    entity.setMinQ(event.getMinQ());
    entity.setR(event.getR());
    entity.setR0(event.getR0());
    entity.setR2(event.getR2());
    entity.setRegulationCapability(event.getRegulationCapability());
    entity.setX(event.getX());
    entity.setX0(event.getX0());
    entity.setX2(event.getX2());
    entity.setEquivalentInjection(event.getEquivalentInjection());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event DeleteEquivalentInjectionEvent
   */
  @EventHandler(payloadType = DeleteEquivalentInjectionEvent.class)
  public void handle(DeleteEquivalentInjectionEvent event) {
    LOGGER.info("handling DeleteEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    EquivalentInjection entity = delete(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignMaxPToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignMaxPToEquivalentInjectionEvent.class)
  public void handle(AssignMaxPToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignMaxPToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity =
        assignMaxP(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignMaxPFromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMaxPFromEquivalentInjectionEvent.class)
  public void handle(UnAssignMaxPFromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignMaxPFromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignMaxP(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignMaxQToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignMaxQToEquivalentInjectionEvent.class)
  public void handle(AssignMaxQToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignMaxQToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity =
        assignMaxQ(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignMaxQFromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMaxQFromEquivalentInjectionEvent.class)
  public void handle(UnAssignMaxQFromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignMaxQFromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignMaxQ(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignMinPToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignMinPToEquivalentInjectionEvent.class)
  public void handle(AssignMinPToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignMinPToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity =
        assignMinP(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignMinPFromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMinPFromEquivalentInjectionEvent.class)
  public void handle(UnAssignMinPFromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignMinPFromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignMinP(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignMinQToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignMinQToEquivalentInjectionEvent.class)
  public void handle(AssignMinQToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignMinQToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity =
        assignMinQ(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignMinQFromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMinQFromEquivalentInjectionEvent.class)
  public void handle(UnAssignMinQFromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignMinQFromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignMinQ(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignRToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignRToEquivalentInjectionEvent.class)
  public void handle(AssignRToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignRToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity = assignR(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignRFromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignRFromEquivalentInjectionEvent.class)
  public void handle(UnAssignRFromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignRFromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignR(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignR0ToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignR0ToEquivalentInjectionEvent.class)
  public void handle(AssignR0ToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignR0ToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity = assignR0(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignR0FromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignR0FromEquivalentInjectionEvent.class)
  public void handle(UnAssignR0FromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignR0FromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignR0(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignR2ToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignR2ToEquivalentInjectionEvent.class)
  public void handle(AssignR2ToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignR2ToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity = assignR2(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignR2FromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignR2FromEquivalentInjectionEvent.class)
  public void handle(UnAssignR2FromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignR2FromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignR2(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignRegulationCapabilityToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignRegulationCapabilityToEquivalentInjectionEvent.class)
  public void handle(AssignRegulationCapabilityToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignRegulationCapabilityToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity =
        assignRegulationCapability(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignRegulationCapabilityFromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignRegulationCapabilityFromEquivalentInjectionEvent.class)
  public void handle(UnAssignRegulationCapabilityFromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignRegulationCapabilityFromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignRegulationCapability(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignXToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignXToEquivalentInjectionEvent.class)
  public void handle(AssignXToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignXToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity = assignX(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignXFromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignXFromEquivalentInjectionEvent.class)
  public void handle(UnAssignXFromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignXFromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignX(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignX0ToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignX0ToEquivalentInjectionEvent.class)
  public void handle(AssignX0ToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignX0ToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity = assignX0(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignX0FromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignX0FromEquivalentInjectionEvent.class)
  public void handle(UnAssignX0FromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignX0FromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignX0(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignX2ToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignX2ToEquivalentInjectionEvent.class)
  public void handle(AssignX2ToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignX2ToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentInjection entity = assignX2(event.getEquivalentInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event UnAssignX2FromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = UnAssignX2FromEquivalentInjectionEvent.class)
  public void handle(UnAssignX2FromEquivalentInjectionEvent event) {
    LOGGER.info("handling UnAssignX2FromEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentInjection entity = unAssignX2(event.getEquivalentInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event AssignEquivalentInjectionToEquivalentInjectionEvent
   */
  @EventHandler(payloadType = AssignEquivalentInjectionToEquivalentInjectionEvent.class)
  public void handle(AssignEquivalentInjectionToEquivalentInjectionEvent event) {
    LOGGER.info("handling AssignEquivalentInjectionToEquivalentInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    EquivalentInjection entity =
        addToEquivalentInjection(event.getEquivalentInjectionId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /*
   * @param	event RemoveEquivalentInjectionFromEquivalentInjectionEvent
   */
  @EventHandler(payloadType = RemoveEquivalentInjectionFromEquivalentInjectionEvent.class)
  public void handle(RemoveEquivalentInjectionFromEquivalentInjectionEvent event) {
    LOGGER.info("handling RemoveEquivalentInjectionFromEquivalentInjectionEvent - " + event);

    EquivalentInjection entity =
        removeFromEquivalentInjection(event.getEquivalentInjectionId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentInjection(entity);
  }

  /**
   * Method to retrieve the EquivalentInjection via an EquivalentInjectionPrimaryKey.
   *
   * @param id Long
   * @return EquivalentInjection
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public EquivalentInjection handle(FindEquivalentInjectionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getEquivalentInjectionId());
  }

  /**
   * Method to retrieve a collection of all EquivalentInjections
   *
   * @param query FindAllEquivalentInjectionQuery
   * @return List<EquivalentInjection>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<EquivalentInjection> handle(FindAllEquivalentInjectionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindEquivalentInjection, but only if the id matches
   *
   * @param entity EquivalentInjection
   */
  protected void emitFindEquivalentInjection(EquivalentInjection entity) {
    LOGGER.info("handling emitFindEquivalentInjection");

    queryUpdateEmitter.emit(
        FindEquivalentInjectionQuery.class,
        query ->
            query.getFilter().getEquivalentInjectionId().equals(entity.getEquivalentInjectionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllEquivalentInjection
   *
   * @param entity EquivalentInjection
   */
  protected void emitFindAllEquivalentInjection(EquivalentInjection entity) {
    LOGGER.info("handling emitFindAllEquivalentInjection");

    queryUpdateEmitter.emit(FindAllEquivalentInjectionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(EquivalentInjectionProjector.class.getName());
}
