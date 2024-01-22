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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * DCGround business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DCGround related services in the case of a DCGround business
 *       related service failing.
 *   <li>Exposes a simpler, uniform DCGround interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DCGround business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DCGroundBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DCGroundBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DCGround Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DCGroundBusinessDelegate
   */
  public static DCGroundBusinessDelegate getDCGroundInstance() {
    return (new DCGroundBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDCGround(CreateDCGroundCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDCGroundId() == null) command.setDCGroundId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCGroundValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDCGroundCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDCGroundCommand of DCGround is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DCGround - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDCGroundCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDCGround(UpdateDCGroundCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DCGroundValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDCGroundCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DCGround - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDCGroundCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDCGroundCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCGroundValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDCGroundCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete DCGround using Id = " + command.getDCGroundId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DCGround via DCGroundFetchOneSummary
   *
   * @param summary DCGroundFetchOneSummary
   * @return DCGroundFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DCGround getDCGround(DCGroundFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DCGroundFetchOneSummary arg cannot be null");

    DCGround entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DCGroundValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DCGround
      // --------------------------------------
      CompletableFuture<DCGround> futureEntity =
          queryGateway.query(
              new FindDCGroundQuery(new LoadDCGroundFilter(summary.getDCGroundId())),
              ResponseTypes.instanceOf(DCGround.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate DCGround with id " + summary.getDCGroundId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DCGrounds
   *
   * @return List<DCGround>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DCGround> getAllDCGround() throws ProcessingException {
    List<DCGround> list = null;

    try {
      CompletableFuture<List<DCGround>> futureList =
          queryGateway.query(
              new FindAllDCGroundQuery(), ResponseTypes.multipleInstancesOf(DCGround.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DCGround";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Inductance on DCGround
   *
   * @param command AssignInductanceToDCGroundCommand
   * @exception ProcessingException
   */
  public void assignInductance(AssignInductanceToDCGroundCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCGroundId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .InductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .InductanceBusinessDelegate.getInductanceInstance();
    DCGroundBusinessDelegate parentDelegate = DCGroundBusinessDelegate.getDCGroundInstance();
    UUID childId = command.getAssignment().getInductanceId();
    Inductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCGroundValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Inductance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Inductance on DCGround
   *
   * @param command UnAssignInductanceFromDCGroundCommand
   * @exception ProcessingException
   */
  public void unAssignInductance(UnAssignInductanceFromDCGroundCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCGroundValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Inductance on DCGround";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R on DCGround
   *
   * @param command AssignRToDCGroundCommand
   * @exception ProcessingException
   */
  public void assignR(AssignRToDCGroundCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCGroundId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    DCGroundBusinessDelegate parentDelegate = DCGroundBusinessDelegate.getDCGroundInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCGroundValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Resistance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign R on DCGround
   *
   * @param command UnAssignRFromDCGroundCommand
   * @exception ProcessingException
   */
  public void unAssignR(UnAssignRFromDCGroundCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCGroundValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R on DCGround";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return DCGround
   */
  private DCGround load(UUID id) throws ProcessingException {
    dCGround =
        DCGroundBusinessDelegate.getDCGroundInstance().getDCGround(new DCGroundFetchOneSummary(id));
    return dCGround;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DCGround dCGround = null;
  private static final Logger LOGGER = Logger.getLogger(DCGroundBusinessDelegate.class.getName());
}
