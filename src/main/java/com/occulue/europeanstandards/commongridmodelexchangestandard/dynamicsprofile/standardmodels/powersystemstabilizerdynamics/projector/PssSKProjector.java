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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PssSK as outlined for the CQRS pattern. All event handling and query handling
 * related to PssSK are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssSKAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssSK")
@Component("pssSK-projector")
public class PssSKProjector extends PssSKEntityProjector {

  // core constructor
  public PssSKProjector(PssSKRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssSKEvent
   */
  @EventHandler(payloadType = CreatePssSKEvent.class)
  public void handle(CreatePssSKEvent event) {
    LOGGER.info("handling CreatePssSKEvent - " + event);
    PssSK entity = new PssSK();
    entity.setPssSKId(event.getPssSKId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UpdatePssSKEvent
   */
  @EventHandler(payloadType = UpdatePssSKEvent.class)
  public void handle(UpdatePssSKEvent event) {
    LOGGER.info("handling UpdatePssSKEvent - " + event);

    PssSK entity = new PssSK();
    entity.setPssSKId(event.getPssSKId());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setK3(event.getK3());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setVsmax(event.getVsmax());
    entity.setVsmin(event.getVsmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event DeletePssSKEvent
   */
  @EventHandler(payloadType = DeletePssSKEvent.class)
  public void handle(DeletePssSKEvent event) {
    LOGGER.info("handling DeletePssSKEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssSK entity = delete(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignK1ToPssSKEvent
   */
  @EventHandler(payloadType = AssignK1ToPssSKEvent.class)
  public void handle(AssignK1ToPssSKEvent event) {
    LOGGER.info("handling AssignK1ToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignK1(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignK1FromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignK1FromPssSKEvent.class)
  public void handle(UnAssignK1FromPssSKEvent event) {
    LOGGER.info("handling UnAssignK1FromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignK1(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignK2ToPssSKEvent
   */
  @EventHandler(payloadType = AssignK2ToPssSKEvent.class)
  public void handle(AssignK2ToPssSKEvent event) {
    LOGGER.info("handling AssignK2ToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignK2(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignK2FromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignK2FromPssSKEvent.class)
  public void handle(UnAssignK2FromPssSKEvent event) {
    LOGGER.info("handling UnAssignK2FromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignK2(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignK3ToPssSKEvent
   */
  @EventHandler(payloadType = AssignK3ToPssSKEvent.class)
  public void handle(AssignK3ToPssSKEvent event) {
    LOGGER.info("handling AssignK3ToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignK3(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignK3FromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignK3FromPssSKEvent.class)
  public void handle(UnAssignK3FromPssSKEvent event) {
    LOGGER.info("handling UnAssignK3FromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignK3(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignT1ToPssSKEvent
   */
  @EventHandler(payloadType = AssignT1ToPssSKEvent.class)
  public void handle(AssignT1ToPssSKEvent event) {
    LOGGER.info("handling AssignT1ToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignT1(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignT1FromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignT1FromPssSKEvent.class)
  public void handle(UnAssignT1FromPssSKEvent event) {
    LOGGER.info("handling UnAssignT1FromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignT1(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignT2ToPssSKEvent
   */
  @EventHandler(payloadType = AssignT2ToPssSKEvent.class)
  public void handle(AssignT2ToPssSKEvent event) {
    LOGGER.info("handling AssignT2ToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignT2(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignT2FromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignT2FromPssSKEvent.class)
  public void handle(UnAssignT2FromPssSKEvent event) {
    LOGGER.info("handling UnAssignT2FromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignT2(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignT3ToPssSKEvent
   */
  @EventHandler(payloadType = AssignT3ToPssSKEvent.class)
  public void handle(AssignT3ToPssSKEvent event) {
    LOGGER.info("handling AssignT3ToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignT3(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignT3FromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignT3FromPssSKEvent.class)
  public void handle(UnAssignT3FromPssSKEvent event) {
    LOGGER.info("handling UnAssignT3FromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignT3(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignT4ToPssSKEvent
   */
  @EventHandler(payloadType = AssignT4ToPssSKEvent.class)
  public void handle(AssignT4ToPssSKEvent event) {
    LOGGER.info("handling AssignT4ToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignT4(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignT4FromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignT4FromPssSKEvent.class)
  public void handle(UnAssignT4FromPssSKEvent event) {
    LOGGER.info("handling UnAssignT4FromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignT4(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignT5ToPssSKEvent
   */
  @EventHandler(payloadType = AssignT5ToPssSKEvent.class)
  public void handle(AssignT5ToPssSKEvent event) {
    LOGGER.info("handling AssignT5ToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignT5(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignT5FromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignT5FromPssSKEvent.class)
  public void handle(UnAssignT5FromPssSKEvent event) {
    LOGGER.info("handling UnAssignT5FromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignT5(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignT6ToPssSKEvent
   */
  @EventHandler(payloadType = AssignT6ToPssSKEvent.class)
  public void handle(AssignT6ToPssSKEvent event) {
    LOGGER.info("handling AssignT6ToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignT6(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignT6FromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignT6FromPssSKEvent.class)
  public void handle(UnAssignT6FromPssSKEvent event) {
    LOGGER.info("handling UnAssignT6FromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignT6(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignVsmaxToPssSKEvent
   */
  @EventHandler(payloadType = AssignVsmaxToPssSKEvent.class)
  public void handle(AssignVsmaxToPssSKEvent event) {
    LOGGER.info("handling AssignVsmaxToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignVsmax(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignVsmaxFromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignVsmaxFromPssSKEvent.class)
  public void handle(UnAssignVsmaxFromPssSKEvent event) {
    LOGGER.info("handling UnAssignVsmaxFromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignVsmax(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event AssignVsminToPssSKEvent
   */
  @EventHandler(payloadType = AssignVsminToPssSKEvent.class)
  public void handle(AssignVsminToPssSKEvent event) {
    LOGGER.info("handling AssignVsminToPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSK entity = assignVsmin(event.getPssSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /*
   * @param	event UnAssignVsminFromPssSKEvent
   */
  @EventHandler(payloadType = UnAssignVsminFromPssSKEvent.class)
  public void handle(UnAssignVsminFromPssSKEvent event) {
    LOGGER.info("handling UnAssignVsminFromPssSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSK entity = unAssignVsmin(event.getPssSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSK(entity);
  }

  /**
   * Method to retrieve the PssSK via an PssSKPrimaryKey.
   *
   * @param id Long
   * @return PssSK
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssSK handle(FindPssSKQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssSKId());
  }

  /**
   * Method to retrieve a collection of all PssSKs
   *
   * @param query FindAllPssSKQuery
   * @return List<PssSK>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssSK> handle(FindAllPssSKQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssSK, but only if the id matches
   *
   * @param entity PssSK
   */
  protected void emitFindPssSK(PssSK entity) {
    LOGGER.info("handling emitFindPssSK");

    queryUpdateEmitter.emit(
        FindPssSKQuery.class,
        query -> query.getFilter().getPssSKId().equals(entity.getPssSKId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssSK
   *
   * @param entity PssSK
   */
  protected void emitFindAllPssSK(PssSK entity) {
    LOGGER.info("handling emitFindAllPssSK");

    queryUpdateEmitter.emit(FindAllPssSKQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssSKProjector.class.getName());
}
