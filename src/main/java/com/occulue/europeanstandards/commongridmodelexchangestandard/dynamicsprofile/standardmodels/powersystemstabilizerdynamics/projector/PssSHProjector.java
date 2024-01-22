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
 * Projector for PssSH as outlined for the CQRS pattern. All event handling and query handling
 * related to PssSH are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssSHAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssSH")
@Component("pssSH-projector")
public class PssSHProjector extends PssSHEntityProjector {

  // core constructor
  public PssSHProjector(PssSHRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssSHEvent
   */
  @EventHandler(payloadType = CreatePssSHEvent.class)
  public void handle(CreatePssSHEvent event) {
    LOGGER.info("handling CreatePssSHEvent - " + event);
    PssSH entity = new PssSH();
    entity.setPssSHId(event.getPssSHId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UpdatePssSHEvent
   */
  @EventHandler(payloadType = UpdatePssSHEvent.class)
  public void handle(UpdatePssSHEvent event) {
    LOGGER.info("handling UpdatePssSHEvent - " + event);

    PssSH entity = new PssSH();
    entity.setPssSHId(event.getPssSHId());
    entity.setK(event.getK());
    entity.setK0(event.getK0());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setK3(event.getK3());
    entity.setK4(event.getK4());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setTd(event.getTd());
    entity.setVsmax(event.getVsmax());
    entity.setVsmin(event.getVsmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event DeletePssSHEvent
   */
  @EventHandler(payloadType = DeletePssSHEvent.class)
  public void handle(DeletePssSHEvent event) {
    LOGGER.info("handling DeletePssSHEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssSH entity = delete(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignKToPssSHEvent
   */
  @EventHandler(payloadType = AssignKToPssSHEvent.class)
  public void handle(AssignKToPssSHEvent event) {
    LOGGER.info("handling AssignKToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignK(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignKFromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignKFromPssSHEvent.class)
  public void handle(UnAssignKFromPssSHEvent event) {
    LOGGER.info("handling UnAssignKFromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignK(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignK0ToPssSHEvent
   */
  @EventHandler(payloadType = AssignK0ToPssSHEvent.class)
  public void handle(AssignK0ToPssSHEvent event) {
    LOGGER.info("handling AssignK0ToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignK0(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignK0FromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignK0FromPssSHEvent.class)
  public void handle(UnAssignK0FromPssSHEvent event) {
    LOGGER.info("handling UnAssignK0FromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignK0(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignK1ToPssSHEvent
   */
  @EventHandler(payloadType = AssignK1ToPssSHEvent.class)
  public void handle(AssignK1ToPssSHEvent event) {
    LOGGER.info("handling AssignK1ToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignK1(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignK1FromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignK1FromPssSHEvent.class)
  public void handle(UnAssignK1FromPssSHEvent event) {
    LOGGER.info("handling UnAssignK1FromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignK1(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignK2ToPssSHEvent
   */
  @EventHandler(payloadType = AssignK2ToPssSHEvent.class)
  public void handle(AssignK2ToPssSHEvent event) {
    LOGGER.info("handling AssignK2ToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignK2(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignK2FromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignK2FromPssSHEvent.class)
  public void handle(UnAssignK2FromPssSHEvent event) {
    LOGGER.info("handling UnAssignK2FromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignK2(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignK3ToPssSHEvent
   */
  @EventHandler(payloadType = AssignK3ToPssSHEvent.class)
  public void handle(AssignK3ToPssSHEvent event) {
    LOGGER.info("handling AssignK3ToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignK3(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignK3FromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignK3FromPssSHEvent.class)
  public void handle(UnAssignK3FromPssSHEvent event) {
    LOGGER.info("handling UnAssignK3FromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignK3(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignK4ToPssSHEvent
   */
  @EventHandler(payloadType = AssignK4ToPssSHEvent.class)
  public void handle(AssignK4ToPssSHEvent event) {
    LOGGER.info("handling AssignK4ToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignK4(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignK4FromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignK4FromPssSHEvent.class)
  public void handle(UnAssignK4FromPssSHEvent event) {
    LOGGER.info("handling UnAssignK4FromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignK4(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignT1ToPssSHEvent
   */
  @EventHandler(payloadType = AssignT1ToPssSHEvent.class)
  public void handle(AssignT1ToPssSHEvent event) {
    LOGGER.info("handling AssignT1ToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignT1(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignT1FromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignT1FromPssSHEvent.class)
  public void handle(UnAssignT1FromPssSHEvent event) {
    LOGGER.info("handling UnAssignT1FromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignT1(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignT2ToPssSHEvent
   */
  @EventHandler(payloadType = AssignT2ToPssSHEvent.class)
  public void handle(AssignT2ToPssSHEvent event) {
    LOGGER.info("handling AssignT2ToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignT2(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignT2FromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignT2FromPssSHEvent.class)
  public void handle(UnAssignT2FromPssSHEvent event) {
    LOGGER.info("handling UnAssignT2FromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignT2(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignT3ToPssSHEvent
   */
  @EventHandler(payloadType = AssignT3ToPssSHEvent.class)
  public void handle(AssignT3ToPssSHEvent event) {
    LOGGER.info("handling AssignT3ToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignT3(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignT3FromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignT3FromPssSHEvent.class)
  public void handle(UnAssignT3FromPssSHEvent event) {
    LOGGER.info("handling UnAssignT3FromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignT3(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignT4ToPssSHEvent
   */
  @EventHandler(payloadType = AssignT4ToPssSHEvent.class)
  public void handle(AssignT4ToPssSHEvent event) {
    LOGGER.info("handling AssignT4ToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignT4(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignT4FromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignT4FromPssSHEvent.class)
  public void handle(UnAssignT4FromPssSHEvent event) {
    LOGGER.info("handling UnAssignT4FromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignT4(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignTdToPssSHEvent
   */
  @EventHandler(payloadType = AssignTdToPssSHEvent.class)
  public void handle(AssignTdToPssSHEvent event) {
    LOGGER.info("handling AssignTdToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignTd(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignTdFromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignTdFromPssSHEvent.class)
  public void handle(UnAssignTdFromPssSHEvent event) {
    LOGGER.info("handling UnAssignTdFromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignTd(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignVsmaxToPssSHEvent
   */
  @EventHandler(payloadType = AssignVsmaxToPssSHEvent.class)
  public void handle(AssignVsmaxToPssSHEvent event) {
    LOGGER.info("handling AssignVsmaxToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignVsmax(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignVsmaxFromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignVsmaxFromPssSHEvent.class)
  public void handle(UnAssignVsmaxFromPssSHEvent event) {
    LOGGER.info("handling UnAssignVsmaxFromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignVsmax(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event AssignVsminToPssSHEvent
   */
  @EventHandler(payloadType = AssignVsminToPssSHEvent.class)
  public void handle(AssignVsminToPssSHEvent event) {
    LOGGER.info("handling AssignVsminToPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssSH entity = assignVsmin(event.getPssSHId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /*
   * @param	event UnAssignVsminFromPssSHEvent
   */
  @EventHandler(payloadType = UnAssignVsminFromPssSHEvent.class)
  public void handle(UnAssignVsminFromPssSHEvent event) {
    LOGGER.info("handling UnAssignVsminFromPssSHEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssSH entity = unAssignVsmin(event.getPssSHId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssSH(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssSH(entity);
  }

  /**
   * Method to retrieve the PssSH via an PssSHPrimaryKey.
   *
   * @param id Long
   * @return PssSH
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssSH handle(FindPssSHQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssSHId());
  }

  /**
   * Method to retrieve a collection of all PssSHs
   *
   * @param query FindAllPssSHQuery
   * @return List<PssSH>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssSH> handle(FindAllPssSHQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssSH, but only if the id matches
   *
   * @param entity PssSH
   */
  protected void emitFindPssSH(PssSH entity) {
    LOGGER.info("handling emitFindPssSH");

    queryUpdateEmitter.emit(
        FindPssSHQuery.class,
        query -> query.getFilter().getPssSHId().equals(entity.getPssSHId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssSH
   *
   * @param entity PssSH
   */
  protected void emitFindAllPssSH(PssSH entity) {
    LOGGER.info("handling emitFindAllPssSH");

    queryUpdateEmitter.emit(FindAllPssSHQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssSHProjector.class.getName());
}
