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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.validator.*;
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
 * PowerSystemStabilizerUserDefined business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PowerSystemStabilizerUserDefined related services in the case of
 *       a PowerSystemStabilizerUserDefined business related service failing.
 *   <li>Exposes a simpler, uniform PowerSystemStabilizerUserDefined interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       PowerSystemStabilizerUserDefined business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PowerSystemStabilizerUserDefinedBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PowerSystemStabilizerUserDefinedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PowerSystemStabilizerUserDefined Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PowerSystemStabilizerUserDefinedBusinessDelegate
   */
  public static PowerSystemStabilizerUserDefinedBusinessDelegate
      getPowerSystemStabilizerUserDefinedInstance() {
    return (new PowerSystemStabilizerUserDefinedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPowerSystemStabilizerUserDefined(
      CreatePowerSystemStabilizerUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPowerSystemStabilizerUserDefinedId() == null)
        command.setPowerSystemStabilizerUserDefinedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerSystemStabilizerUserDefinedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePowerSystemStabilizerUserDefinedCommand - by convention the future return
      // value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePowerSystemStabilizerUserDefinedCommand of PowerSystemStabilizerUserDefined is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PowerSystemStabilizerUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePowerSystemStabilizerUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePowerSystemStabilizerUserDefined(
      UpdatePowerSystemStabilizerUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PowerSystemStabilizerUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePowerSystemStabilizerUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PowerSystemStabilizerUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePowerSystemStabilizerUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePowerSystemStabilizerUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerSystemStabilizerUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePowerSystemStabilizerUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PowerSystemStabilizerUserDefined using Id = "
              + command.getPowerSystemStabilizerUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PowerSystemStabilizerUserDefined via
   * PowerSystemStabilizerUserDefinedFetchOneSummary
   *
   * @param summary PowerSystemStabilizerUserDefinedFetchOneSummary
   * @return PowerSystemStabilizerUserDefinedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PowerSystemStabilizerUserDefined getPowerSystemStabilizerUserDefined(
      PowerSystemStabilizerUserDefinedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "PowerSystemStabilizerUserDefinedFetchOneSummary arg cannot be null");

    PowerSystemStabilizerUserDefined entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PowerSystemStabilizerUserDefinedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PowerSystemStabilizerUserDefined
      // --------------------------------------
      CompletableFuture<PowerSystemStabilizerUserDefined> futureEntity =
          queryGateway.query(
              new FindPowerSystemStabilizerUserDefinedQuery(
                  new LoadPowerSystemStabilizerUserDefinedFilter(
                      summary.getPowerSystemStabilizerUserDefinedId())),
              ResponseTypes.instanceOf(PowerSystemStabilizerUserDefined.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PowerSystemStabilizerUserDefined with id "
              + summary.getPowerSystemStabilizerUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PowerSystemStabilizerUserDefineds
   *
   * @return List<PowerSystemStabilizerUserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PowerSystemStabilizerUserDefined> getAllPowerSystemStabilizerUserDefined()
      throws ProcessingException {
    List<PowerSystemStabilizerUserDefined> list = null;

    try {
      CompletableFuture<List<PowerSystemStabilizerUserDefined>> futureList =
          queryGateway.query(
              new FindAllPowerSystemStabilizerUserDefinedQuery(),
              ResponseTypes.multipleInstancesOf(PowerSystemStabilizerUserDefined.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PowerSystemStabilizerUserDefined";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Proprietary on PowerSystemStabilizerUserDefined
   *
   * @param command AssignProprietaryToPowerSystemStabilizerUserDefinedCommand
   * @exception ProcessingException
   */
  public void assignProprietary(AssignProprietaryToPowerSystemStabilizerUserDefinedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerSystemStabilizerUserDefinedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    PowerSystemStabilizerUserDefinedBusinessDelegate parentDelegate =
        PowerSystemStabilizerUserDefinedBusinessDelegate
            .getPowerSystemStabilizerUserDefinedInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerSystemStabilizerUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Proprietary on PowerSystemStabilizerUserDefined
   *
   * @param command UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand
   * @exception ProcessingException
   */
  public void unAssignProprietary(
      UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerSystemStabilizerUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Proprietary on PowerSystemStabilizerUserDefined";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PowerSystemStabilizerUserDefined
   */
  private PowerSystemStabilizerUserDefined load(UUID id) throws ProcessingException {
    powerSystemStabilizerUserDefined =
        PowerSystemStabilizerUserDefinedBusinessDelegate
            .getPowerSystemStabilizerUserDefinedInstance()
            .getPowerSystemStabilizerUserDefined(
                new PowerSystemStabilizerUserDefinedFetchOneSummary(id));
    return powerSystemStabilizerUserDefined;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PowerSystemStabilizerUserDefined powerSystemStabilizerUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(PowerSystemStabilizerUserDefinedBusinessDelegate.class.getName());
}
