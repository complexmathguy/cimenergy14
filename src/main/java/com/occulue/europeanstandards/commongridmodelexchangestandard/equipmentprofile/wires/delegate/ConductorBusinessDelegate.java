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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
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
 * Conductor business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Conductor related services in the case of a Conductor business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Conductor interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Conductor business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ConductorBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ConductorBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Conductor Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ConductorBusinessDelegate
   */
  public static ConductorBusinessDelegate getConductorInstance() {
    return (new ConductorBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createConductor(CreateConductorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getConductorId() == null) command.setConductorId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConductorValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateConductorCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateConductorCommand of Conductor is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Conductor - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateConductorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateConductor(UpdateConductorCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ConductorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateConductorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Conductor - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteConductorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteConductorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConductorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteConductorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Conductor using Id = " + command.getConductorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Conductor via ConductorFetchOneSummary
   *
   * @param summary ConductorFetchOneSummary
   * @return ConductorFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Conductor getConductor(ConductorFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ConductorFetchOneSummary arg cannot be null");

    Conductor entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ConductorValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Conductor
      // --------------------------------------
      CompletableFuture<Conductor> futureEntity =
          queryGateway.query(
              new FindConductorQuery(new LoadConductorFilter(summary.getConductorId())),
              ResponseTypes.instanceOf(Conductor.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Conductor with id " + summary.getConductorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Conductors
   *
   * @return List<Conductor>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Conductor> getAllConductor() throws ProcessingException {
    List<Conductor> list = null;

    try {
      CompletableFuture<List<Conductor>> futureList =
          queryGateway.query(
              new FindAllConductorQuery(), ResponseTypes.multipleInstancesOf(Conductor.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Conductor";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Length on Conductor
   *
   * @param command AssignLengthToConductorCommand
   * @exception ProcessingException
   */
  public void assignLength(AssignLengthToConductorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getConductorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    ConductorBusinessDelegate parentDelegate = ConductorBusinessDelegate.getConductorInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ConductorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Length on Conductor
   *
   * @param command UnAssignLengthFromConductorCommand
   * @exception ProcessingException
   */
  public void unAssignLength(UnAssignLengthFromConductorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConductorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Length on Conductor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Conductor
   */
  private Conductor load(UUID id) throws ProcessingException {
    conductor =
        ConductorBusinessDelegate.getConductorInstance()
            .getConductor(new ConductorFetchOneSummary(id));
    return conductor;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Conductor conductor = null;
  private static final Logger LOGGER = Logger.getLogger(ConductorBusinessDelegate.class.getName());
}
